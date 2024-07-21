package com.example.FirebaseConfig;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.SetOptions;
import com.google.cloud.firestore.WriteResult;

public class FirebaseInit {

    private static Firestore db;

    public static void initializeFirebase() throws IOException {

        FileInputStream serviceAccount = new FileInputStream(
                "C:\\Users\\hp\\OneDrive\\Desktop\\Maven\\FirebaseCrud\\demo\\src\\main\\resources\\fir-crud-319d8-firebase-adminsdk-7qq7w-8d0bf9b1ec.json");

        @SuppressWarnings("deprecation")
        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .setDatabaseUrl("https://fx-project-8347c-default-rtdb.asia-southeast1.firebasedatabase.app")
                .build();

        FirebaseApp.initializeApp(options);
        db = FirestoreClient.getFirestore();
    }

    public void createRec() throws InterruptedException, ExecutionException {
        Map<String, Object> teamData = new HashMap<>();
        teamData.put("team", "India");
        teamData.put("captain", "Rohit Sharma");
        teamData.put("manOfMatch", "Virat Kohli");

        ApiFuture<WriteResult> future = db.collection("T20WCC").document("winner").set(teamData);

        System.out.println("Update time : " + future.get().getUpdateTime());
    }

    public void readRec() throws InterruptedException, ExecutionException {
        DocumentReference docRef = db.collection("T20WCC").document("winner");

        ApiFuture<DocumentSnapshot> snapshot = docRef.get();
        DocumentSnapshot docSnap = snapshot.get();
        if (docSnap.exists()) {
            System.out.println(docSnap.get("team"));
            System.out.println(docSnap.get("captain"));
            System.out.println(docSnap.get("manOfMatch"));
        } else {
            System.out.println("Document Not Found");
        }
    }

    public void updateRec() {
        Map<String, Object> updateData = new HashMap<>();
        updateData.put("manOfSeries", "J.Bumrah");

        ApiFuture<WriteResult> future = db.collection("T20WCC").document("winner").set(updateData, SetOptions.merge());
    }
}
