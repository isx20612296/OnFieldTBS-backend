package org.proyectofinal.OnFieldTBS.services;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import org.proyectofinal.OnFieldTBS.domains.dtos.ResponseGeocoding;
import org.proyectofinal.OnFieldTBS.domains.dtos.ResponseLocation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.time.Duration;

@Service
public class LocationService {
    @Value("${geocoding.apiUrl}")
    private String GEOCODING_RESOURCE;
    @Value("${geocoding.apiKey}")
    private String API_KEY;

    public String requestLocation(String address) throws IOException, InterruptedException {
        HttpClient httpClient = HttpClient.newHttpClient();
        String encodedQuery = URLEncoder.encode(address, StandardCharsets.UTF_8);
        String requestUri = GEOCODING_RESOURCE + "?key=" + API_KEY + "&address=" + encodedQuery;

        // Build the request
        HttpRequest geocodingRequest = HttpRequest.newBuilder().GET().uri(URI.create(requestUri))
                .timeout(Duration.ofMillis(2000)).build();

        // Get the response from the request
        HttpResponse<String> geocodingResponse = httpClient.send(geocodingRequest,
                HttpResponse.BodyHandlers.ofString());
        return geocodingResponse.body();
    }

    public ResponseLocation getLocation(String address){
        ObjectMapper mapper = new ObjectMapper().disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        ResponseLocation location = new ResponseLocation();
        try {
            String response = requestLocation(address);
            ResponseGeocoding responseGeocoding = mapper.readValue(response, ResponseGeocoding.class);
            location = ResponseGeocoding.getLocation(responseGeocoding);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return location;
    }
}
