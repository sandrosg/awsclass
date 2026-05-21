package com.aws.classe3.controller;

import com.aws.classe3.service.SqsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/sqs")
@RequiredArgsConstructor
public class SqsController {

    private final SqsService sqsService;

    @GetMapping("/send")
    public String send(@RequestParam String mensagem) {
        sqsService.sendMessage(mensagem);
        return "Mensagem enviada com sucesso: " + mensagem;
    }
}
