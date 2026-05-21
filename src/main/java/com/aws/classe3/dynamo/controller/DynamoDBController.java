package com.aws.classe3.dynamo.controller;

import com.aws.classe3.dynamo.service.DynamoDBService;
import io.awspring.cloud.dynamodb.DynamoDbTemplate;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/dynamo")
public class DynamoDBController {

    private final DynamoDBService dynamoDBService;

    public DynamoDBController(DynamoDBService dynamoDBService) {
        this.dynamoDBService = dynamoDBService;
    }

    @GetMapping(value = "/logs", produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> list() {
        List<String> logsLista = dynamoDBService.listaLogs();

        String logsFormatados = String.join("\n", logsLista);

        return ResponseEntity.ok(logsFormatados);
    }
}
