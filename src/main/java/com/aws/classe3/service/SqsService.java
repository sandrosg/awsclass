package com.aws.classe3.service;

import io.awspring.cloud.sqs.operations.SqsTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SqsService {

    private final SqsTemplate sqsTemplate;

    @Value("${aws.sqs.queue-url}")
    private String queueUrl;

    public void sendMessage(String message) {
        sqsTemplate.send(to -> to
                .queue(queueUrl)
                .payload(message)
        );
        System.out.println("Mensagem enviada para a fila: " + message);
    }
}
