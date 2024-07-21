package com.example;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

import com.example.FirebaseConfig.FirebaseInit;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException, ExecutionException {
        FirebaseInit.initializeFirebase();
        FirebaseInit obj = new FirebaseInit();

        // Uncomment the method calls based on what you want to execute

        obj.createRec();
        obj.readRec();
        obj.updateRec();
    }
}
