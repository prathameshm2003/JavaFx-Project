package com.imgapi.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class DataUrls {

    public StringBuffer getResponseData() throws IOException {
        // API URL for fetching a random image
        String url = "https://api.unsplash.com/photos/random/?client_id=MkZUtz_O0OLASJaTpCfrrR8-9C8THgOMqUaIvWiRyzs";

        // Establishing a connection to the API
        HttpURLConnection httpClient = (HttpURLConnection) new URL(url).openConnection();
        httpClient.setRequestMethod("GET");

        StringBuffer response = new StringBuffer();

        // Get the response code from the API
        int responseCode = httpClient.getResponseCode();

        if (responseCode == HttpURLConnection.HTTP_OK) {
            // Read the response from the API
            BufferedReader in = new BufferedReader(new InputStreamReader(httpClient.getInputStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            return response;
        } else {
            // Throw an exception if the GET request failed
            throw new RuntimeException("GET request failed with response code " + responseCode);
        }
    }
}
