package com.nnh;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class ActualizaLibro {
    public static void main(String[] args) {
        MongoClient mc = new MongoClient();
        MongoDatabase mdb = mc.getDatabase("biblioteca");
        MongoCollection mco = mdb.getCollection("libros");

        // Cada document es una opertura de llaves
        Document filtrado = new Document("titulo", "Lazarillo de Tormes");
        Document actualizo = new Document("$set", new Document("precio", 5));

        mco.updateOne(filtrado, actualizo);
        mc.close();
    }
}
