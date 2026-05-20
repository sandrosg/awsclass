package com.aws.classe3.service;

import com.aws.classe3.infra.entity.Logs;
import com.aws.classe3.infra.repository.LogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LogService {

    private final LogRepository logRepository;

    public List<String> getLogs() {
        return logRepository.findAll()
                .stream()
                .map(log -> log.getCep() + " - " + log.getData())
                .toList();
    }

    public void saveLog(Logs log){
        logRepository.save(log);
    }

}
