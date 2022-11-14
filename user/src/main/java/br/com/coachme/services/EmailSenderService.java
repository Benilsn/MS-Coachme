package br.com.coachme.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.netflix.discovery.EurekaClientNames;
import com.netflix.discovery.shared.transport.EurekaHttpClient;
import org.springframework.stereotype.Service;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

@Service
public class EmailSenderService {

    private final URI uri = URI.create("http://localhost:8080/send-email");


    public void sendEmail(Map<String, String> emailMap) throws JsonProcessingException {

        ObjectMapper objectMapper = new ObjectMapper();
        String requestBody = objectMapper.
                writerWithDefaultPrettyPrinter()
                .writeValueAsString(emailMap);

        HttpRequest post = HttpRequest.newBuilder()
                .uri(uri)
                .header("Content-Type", "application/json; charset=UTF-8")
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();

        HttpClient.newHttpClient()
                .sendAsync(post, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::statusCode)
                .thenAccept(System.out::println);
    }
}
