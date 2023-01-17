package com.nnh;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

// Incrementa el precio de cada libro en 2 euros
public class ActualizaMuchos {
    public static void main(String[] args) {
        MongoClient mc = new MongoClient();
        MongoDatabase mdb = mc.getDatabase("biblioteca");
        MongoCollection mco = mdb.getCollection("libros");

        Document filtro = new Document();
        Document actualizo = new Document("$inc", new Document("precio", 2));

        mco.updateMany(filtro, actualizo);
        mc.close();
    }
}