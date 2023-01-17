package com.nnh.ejemplos;
// -cp /usr/share/java/mongo-java-driver.jar

import com.mongodb.*;
import com.mongodb.MongoClient;
import com.mongodb.client.*;
import org.bson.codecs.configuration.*;
import org.bson.codecs.pojo.*;
import org.bson.*;
import java.util.*;
import org.bson.types.ObjectId;
import org.bson.codecs.pojo.annotations.*;
import com.mongodb.client.FindIterable;

public class Ej5 {
    public static void main(String args[])
    {
        MongoClient mongoClient = new MongoClient();
        MongoDatabase db = mongoClient.getDatabase("biblioteca");

/*        CodecRegistry pojoCodecRegistry = CodecRegistries.fromRegistries(MongoClient.getDefaultCodecRegistry(),    CodecRegistries.fromProviders(PojoCodecProvider.builder().automatic(true).build()));
        MongoClient cliente = new MongoClient("localhost", MongoClientOptions.builder().codecRegistry(pojoCodecRegistry).build());
        MongoDatabase db = cliente.getDatabase("biblioteca");*/

        // Definimos el document de filtrado
        Document documento = new Document("autor", "Robert Louis Stevenson");
        // Una consulta retorna un objeto findIterable
        FindIterable findIterable = db.getCollection("libros").find(documento).limit(10);
        List<Libro> libros = new ArrayList<Libro>();
        Libro libro = null;
        // Par apoder iterar con él usamos el método iterator() que retorna un cursor mongocursor
        MongoCursor iter = findIterable.iterator();
        while (iter.hasNext()) {
            // Sobre el mongocursor next() retorna el siguiente document
            documento = (Document)iter.next();
            libro = new Libro();
            libro.setId(documento.getObjectId("_id"));
            libro.setTitulo(documento.getString("titulo"));
            libro.setDescripcion(documento.getString("descripcion"));
            libro.setAutor(documento.getString("autor"));
            libro.setFecha(documento.getDate("fecha"));
            libro.setDisponible(documento.getBoolean("disponible", false));
            libros.add(libro);
        }
        // Los muestro con el método foreach() convirtiendo a stream
        // También podía haberlo hecho con el bucle for (foreach) y los métodos hasnext() y next()
        libros.stream().forEach(System.out::println);
        mongoClient.close();
    }
}

