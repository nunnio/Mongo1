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

// Actualiza un documento
public class Ej6 {
    public static void main(String args[])
    {
        MongoClient mongoClient = new MongoClient();
        MongoDatabase db = mongoClient.getDatabase("biblioteca");

/*        CodecRegistry pojoCodecRegistry = CodecRegistries.fromRegistries(MongoClient.getDefaultCodecRegistry(),    CodecRegistries.fromProviders(PojoCodecProvider.builder().automatic(true).build()));
        MongoClient cliente = new MongoClient("localhost", MongoClientOptions.builder().codecRegistry(pojoCodecRegistry).build());
        MongoDatabase db = cliente.getDatabase("biblioteca");*/

        /*
        Los Métodos de Actualización, como updateOne, requieren 2 parámetros:
        1. El documento filtrado
        2. El documento de actualización
        */
        db.getCollection("libros").updateOne(new Document("titulo", "Secuestrado"),
                new Document("$set", new Document("autor", "Pepe Gotera")));
        mongoClient.close();
    }
}

