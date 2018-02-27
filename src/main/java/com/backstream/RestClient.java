package com.backstream;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class RestClient {

    public static String get() {

        try {
            Client client = Client.create();
            WebResource webResource = client
                    .resource("http://api.nobelprize.org/v1/laureate/json");

            ClientResponse response = webResource.accept("application/json")
                    .get(ClientResponse.class);

            if (response.getStatus() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + response.getStatus());
            }

            return cleanupResponse(response.getEntity(String.class));

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String cleanupResponse(String response) {
        return response.replace("\"affiliations\":[[]]", "\"affiliations\":[]");
    }
}
