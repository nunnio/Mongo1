package com.nnh;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class InsertaMuchos {
    public static void main(String[] args) {
        MongoClient mc = new MongoClient();
        MongoDatabase mdb = mc.getDatabase("biblioteca");
        MongoCollection mco = mdb.getCollection("libros");
        // Creo la colección de libros a insertar como un list
        List<Document> docs = new ArrayList<Document>();
        Libro l1 = new Libro(1L, "El lazarillo de Tormes", "Anónimo", 12);
        Libro l2 = new Libro(2L, "Frankestein", "Mart Shelly", 10);
        Libro l3 = new Libro(3L, "Dracula", "Bram Stoker", 14);
        Libro l4 = new Libro(4L, "Las maravitupendas aventuras de Nuno el Ornitorrinco", "Javier ViceGOD", 72);

        // TODO hacer el mismo ejercicio pero con un único array de libros y añadirlos con un foreach
        // Creo un document para cada libro y lo añado siempre al ArrayList
        Document doc = new Document("_id", l1.getId())
                        .append("titulo",l1.getTitulo())
                        .append("autor",l1.getAutor())
                        .append("precio", l1.getPrecio());
        docs.add(doc);
        doc = new Document("_id",l2.getId())
                .append("titulo",l2.getTitulo())
                .append("autor",l2.getAutor())
                .append("precio",l2.getPrecio());
        docs.add(doc);
        doc = new Document("_id",l3.getId())
                .append("titulo",l3.getTitulo())
                .append("autor",l3.getAutor())
                .append("precio",l3.getPrecio());
        docs.add(doc);
        doc = new Document("_id",l4.getId())
                .append("titulo",l4.getTitulo())
                .append("autor",l4.getAutor())
                .append("precio",l4.getPrecio());
        docs.add(doc);
        // Guardo el ArrayList con todos los documentos de los libros en la BBDD
        mco.insertMany(docs);
        mc.close();
    }
}
