package com.aws.classe3.service;

import io.awspring.cloud.sns.core.SnsTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SnsService {

    private final SnsTemplate snsTemplate;

    @Value("${aws.sns.topic-arn}")
    private String topicArn;

    public void sendNotification(String subject, String message) {
        System.out.println("--------------------------------------------------");
        System.out.println("SNS: Tentando enviar notificação...");
        System.out.println("SNS: Tópico: " + topicArn);
        System.out.println("SNS: Assunto: " + subject);
        
        snsTemplate.sendNotification(topicArn, message, subject);
        
        System.out.println("SNS: Método sendNotification executado sem erros.");
        System.out.println("--------------------------------------------------");
    }
}
