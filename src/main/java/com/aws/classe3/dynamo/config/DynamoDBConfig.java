package com.aws.classe3.dynamo.config;

import com.aws.classe3.dynamo.entity.LogsDynamo;
import io.awspring.cloud.dynamodb.DynamoDbTableNameResolver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;

@Configuration
public class DynamoDBConfig {

    @Value("${aws.region}")
    private String region;

    @Value("${aws.accessKeyId}")
    private String accessKeyId;

    @Value("${aws.secretKey}")
    private String secretKey;

    @Value("${aws.dynamo.tabela.logs}")
    private String table;

    @Bean
    public DynamoDbClient dynamoDbClient() {
        return DynamoDbClient.builder()
                .region(Region.of(region))
                .credentialsProvider(
                        StaticCredentialsProvider.create(
                                AwsBasicCredentials.create(accessKeyId, secretKey)
                        )
                )
                .build();
    }

    @Bean
    public DynamoDbTableNameResolver dynamoDbTableNameResolver() {
        return new DynamoDbTableNameResolver() {
            @Override
            public <T> String resolve(Class<T> clazz) {
                if (clazz.equals(LogsDynamo.class)) {
                    return table;
                }
                return clazz.getSimpleName();
            }
        };
    }
}