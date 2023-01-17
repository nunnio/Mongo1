package com.nnh;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;


public class InsertaUno {
    public static void main(String[] args) {
        MongoClient mc = new MongoClient("localhost");
        MongoDatabase mdb = mc.getDatabase("biblioteca");
        MongoCollection mco = mdb.getCollection("libros");
        Libro l1 = new Libro(7L, "Guardias, guardias!", "Terry Pratchett", 18);
        Document doc = new Document("_id", l1.getId())
                .append("titulo",l1.getTitulo())
                .append("autor",l1.getAutor())
                .append("precio", l1.getPrecio());
        mco.insertOne(doc);
        mc.close();
    }
}