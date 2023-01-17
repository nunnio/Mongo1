package com.nnh.ejemplos;// -cp /usr/share/java/mongo-java-driver.jar

import com.mongodb.*;
import com.mongodb.MongoClient;
import com.mongodb.client.*;
import org.bson.codecs.configuration.*;
import org.bson.codecs.pojo.*;
import org.bson.*;
import java.util.*;
import org.bson.types.ObjectId;
import org.bson.codecs.pojo.annotations.*;

public class Ej3 {
    public static void main(String args[])
    {
        MongoClient mongoClient = new MongoClient();
        MongoDatabase db = mongoClient.getDatabase("biblioteca");

/*        CodecRegistry pojoCodecRegistry = CodecRegistries.fromRegistries(MongoClient.getDefaultCodecRegistry(),    CodecRegistries.fromProviders(PojoCodecProvider.builder().automatic(true).build()));
        MongoClient cliente = new MongoClient("localhost", MongoClientOptions.builder().codecRegistry(pojoCodecRegistry).build());
        MongoDatabase db = cliente.getDatabase("biblioteca");*/

        Libro libro = new Libro("Secuestrado","Las aventuras de David Balfour","Robert Louis Stevenson",(new GregorianCalendar(102 + 1900, 5, 2)).getTime(),true);

        db.getCollection("libros").insertOne(new Document()
//.append("id", libro.getId())
                .append("titulo", libro.getTitulo())
                .append("descripcion", libro.getDescripcion())
                .append("autor", libro.getAutor())
                .append("fecha", libro.getFecha())
                .append("disponible", libro.getDisponible()));

        mongoClient.close();
    }
}

