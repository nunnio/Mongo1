package com.nnh.ejemplos;// -cp /usr/share/java/mongo-java-driver.jar

import com.mongodb.*;
import com.mongodb.MongoClient;
import com.mongodb.client.*;
import org.bson.codecs.configuration.*;
import org.bson.codecs.pojo.*;

public class Ej2 {
    public static void main(String args[])
    {
        //MongoClient mongoClient = new MongoClient();

        CodecRegistry pojoCodecRegistry = CodecRegistries.fromRegistries(MongoClient.getDefaultCodecRegistry(), CodecRegistries.fromProviders(PojoCodecProvider.builder().automatic(true).build()));
        MongoClient cliente = new MongoClient("localhost", MongoClientOptions.builder().codecRegistry(pojoCodecRegistry).build());
        /*MongoDatabase db = mongoClient.getDatabase("basededatos");
        mongoClient.close();*/
        MongoDatabase db = cliente.getDatabase("basededatos");
        cliente.close();
    }
}	