package com.nnh.ejemplos;
// -cp /usr/share/java/mongo-java-driver.jar

import com.mongodb.MongoClient;
import com.mongodb.client.*;

public class Ej1 {
    public static void main(String args[])
    {
        MongoClient mongoClient = new MongoClient();
        MongoDatabase db = mongoClient.getDatabase("basededatos");
        mongoClient.close();
    }
}	