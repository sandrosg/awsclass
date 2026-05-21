package com.aws.classe3.dynamo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbAttribute;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbSortKey;

import java.time.Instant;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@DynamoDbBean
public class LogsDynamo {

    private UUID id;

    private Instant data;

    private String cep;

    public LogsDynamo(String cep) {
        this.cep = cep;
        this.data =  Instant.now();
        this.id = UUID.randomUUID();
    }

    @DynamoDbPartitionKey
    @DynamoDbAttribute("id")
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @DynamoDbAttribute("data")
    public Instant getData() {
        return data;
    }

    public void setData(Instant data) {
        this.data = data;
    }

    @DynamoDbAttribute("cep")
    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
}
