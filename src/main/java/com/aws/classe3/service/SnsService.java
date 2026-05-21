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
        snsTemplate.sendNotification(topicArn, message, subject);
        System.out.println("Notificação enviada via SNS para o tópico: " + topicArn);
    }
}
