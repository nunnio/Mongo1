package com.nnh;// -cp /usr/share/java/mongo-java-driver.jar

import com.mongodb.MongoClient;
import com.mongodb.client.*;

public class Conecta {
    public static void main(String args[])
    {
        MongoClient mongoClient = new MongoClient();
        MongoDatabase db = mongoClient.getDatabase("basededatos");
        mongoClient.close();
    }
}	