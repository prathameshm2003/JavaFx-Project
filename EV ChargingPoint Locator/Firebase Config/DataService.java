package com.evlocator.firebaseConfig;

import com.evlocator.NearbyPoints.NearbyPoints;
import com.google.api.core.ApiFuture;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public class DataService {

    // Firestore instance for database operations
    // public static Firestore db;

    // Static block to initialize Firebase when the class is loaded
    static {
        try {
            initializeFirebase();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to initialize Firebase with service account credentials
    private static void initializeFirebase() throws IOException {
        FileInputStream serviceAccount = new FileInputStream(
                "C:\\Users\\hp\\OneDrive\\Desktop\\EV Locator\\EV locator\\locator\\src\\main\\resources\\ev-locator.json");

        // Configure Firebase options with the credentials
        @SuppressWarnings("deprecation")
        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                // Uncomment and set the Database URL if needed
                // .setDatabaseUrl("https:")
                .build();

        // Initialize Firebase app with the options
        FirebaseApp.initializeApp(options);
        // Get Firestore instance
        NearbyPoints.db = FirestoreClient.getFirestore();
    }

    // Method to add data to a specified collection and document
    public void addData(String collection, String document, Map<String, Object> data)
            throws ExecutionException, InterruptedException {
        DocumentReference docRef = NearbyPoints.db.collection(collection).document(document);
        ApiFuture<WriteResult> result = docRef.set(data);
        // Block until the write operation is complete
        result.get();
    }

    // Method to retrieve data from a specified collection and document
    public DocumentSnapshot getData(String collection, String document)
            throws ExecutionException, InterruptedException {
        try {
            DocumentReference docRef = NearbyPoints.db.collection(collection).document(document);
            ApiFuture<DocumentSnapshot> future = docRef.get();
            // Block until the read operation is complete and return the document snapshot
            return future.get();
        } catch (Exception e) {
            // Print the stack trace for debugging
            e.printStackTrace();
            // Re-throw the exception or handle it based on your application's needs
            throw e;
        }
    }

    // Method to authenticate a user by comparing the provided password with the
    // stored password
    public boolean authenticateUser(String username, String password) throws ExecutionException, InterruptedException {
        // Retrieve the document for the user with the given username
        DocumentSnapshot document = NearbyPoints.db.collection("users").document(username).get().get();
        if (document.exists()) {
            // Get the stored password from the document
            String storedPassword = document.getString("password");
            // Compare the provided password with the stored password
            return password.equals(storedPassword);
        }
        return false;
    }
}
