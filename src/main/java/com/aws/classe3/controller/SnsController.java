package com.aws.classe3.controller;

import com.aws.classe3.service.SnsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/sns")
@RequiredArgsConstructor
public class SnsController {

    private final SnsService snsService;

    @GetMapping("/send")
    public String send(@RequestParam String titulo, @RequestParam String mensagem) {
        snsService.sendNotification(titulo, mensagem);
        return "Notificação SNS enviada: " + titulo;
    }
}
