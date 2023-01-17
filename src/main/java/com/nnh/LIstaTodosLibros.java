package com.nnh;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCursor;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;


import java.util.ArrayList;
import java.util.List;


public class LIstaTodosLibros {
    public static void main(String[] args) {
        MongoClient mc = new MongoClient();
        MongoDatabase mdb = mc.getDatabase("biblioteca");
        MongoCollection mco = mdb.getCollection("libros");
        List<Libro> libros = new ArrayList<>();
        // Documento de filtrado
        Document doc = new Document("autor", "Terry Pratchett");
        FindIterable fit = mco.find(doc);
        // A partir de findIterable hacemos el iterator
        MongoCursor mcursor = fit.iterator();
        while(mcursor.hasNext()){
            doc = (Document) mcursor.next();
            Libro l1 = new Libro();
            l1.setId(doc.getLong("_id"));
            l1.setTitulo(doc.getString("titulo"));
            l1.setAutor(doc.getString("autor"));
            l1.setPrecio(doc.getDouble("precio"));
            libros.add(l1);
        }
        // Ya tenemos el arraylist con todos los libros de la consulta, ahora los mostramos
        for(Libro l : libros){// (que es foreach)
            System.out.println(l);
        }
    }
}
