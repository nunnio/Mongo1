package com.nnh;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class ReemplazaUno {
    public static void main(String[] args) {
        Long id = null; // ó 3L
        MongoClient mc = new MongoClient();
        MongoDatabase mdb = mc.getDatabase("biblioteca");
        MongoCollection mco = mdb.getCollection("libros");

        Document doc = new Document("autor", "Anónimo");
        FindIterable<Document> fi = mco.find(doc).limit(1);
        //Libro l1 = null;

        MongoCursor mcu =  fi.iterator();

        if(mcu.hasNext()){
            // Como el documento creado inicialmente ya no lo necesito lo puedo reutilizar.
            doc = (Document)mcu.next();
            id = doc.getLong("_id");
            //l1.setId(id);
        }
        Libro l2 = new Libro(id, "Don Quijote de la Mancha", "Miguel de Cervantes", 20);
        doc = new Document("titulo", l2.getTitulo()).append("autor", l2.getAutor()).append("precio", l2.getPrecio());
        mco.replaceOne(new Document("_id", id), doc);

    }
}
