package com.aws.classe3.dynamo.service;

import com.aws.classe3.dynamo.entity.LogsDynamo;
import com.aws.classe3.infra.entity.Logs;
import io.awspring.cloud.dynamodb.DynamoDbTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.enhanced.dynamodb.Key;
import software.amazon.awssdk.enhanced.dynamodb.model.QueryConditional;
import software.amazon.awssdk.enhanced.dynamodb.model.QueryEnhancedRequest;

import java.util.List;

@Service
public class DynamoDBService {

    @Autowired
    private DynamoDbTemplate dynamoDbTemplate;

    public void save(String cep) {
        dynamoDbTemplate.save(new LogsDynamo(cep));
    }

    public List<String> listaLogs(){

        var logs = dynamoDbTemplate.scanAll(LogsDynamo.class);

        return logs.items().stream()
                .map(log -> "CEP: " + log.getCep() + " | Data: " + log.getData() + " | ID: " + log.getId())
                .toList();
    }

}
