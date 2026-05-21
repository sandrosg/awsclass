package com.aws.classe3.listener;

import com.aws.classe3.dynamo.service.DynamoDBService;
import io.awspring.cloud.sqs.annotation.SqsListener;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SqsMessageListener {

    private final DynamoDBService dynamoDBService;

    // O nome aqui pode ser o nome da fila ou a URL definida no properties
    @SqsListener("${aws.sqs.queue-url}")
    public void listen(String message) {
        System.out.println("--------------------------------------------------");
        System.out.println("PROCESSANDO CEP NO SQS: " + message);
        
        try {
            dynamoDBService.save(message);
            System.out.println("CEP " + message + " salvo com sucesso no DynamoDB via SQS.");
        } catch (Exception e) {
            System.err.println("Erro ao processar CEP do SQS: " + e.getMessage());
        }
        
        System.out.println("--------------------------------------------------");
    }
}
