package com.nnh;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class Delete {
    public static void main(String[] args) {
        MongoClient mc = new MongoClient();
        MongoDatabase mdb = mc.getDatabase("biblioteca");
        MongoCollection mco = mdb.getCollection("libros");

        Document filtro = new Document("$lt", 20);
        Document doc = new Document("precio", filtro);

        mco.deleteMany(doc);
    }
}