package com.aws.classe3.listener;

import io.awspring.cloud.sqs.annotation.SqsListener;
import org.springframework.stereotype.Component;

@Component
public class SqsMessageListener {

    // O nome aqui pode ser o nome da fila ou a URL definida no properties
    @SqsListener("${aws.sqs.queue-url}")
    public void listen(String message) {
        System.out.println("--------------------------------------------------");
        System.out.println("MENSAGEM RECEBIDA DO SQS: " + message);
        System.out.println("--------------------------------------------------");
        
        // Aqui você poderia, por exemplo, salvar no banco ou processar o CEP
    }
}
