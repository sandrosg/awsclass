package com.aws.classe3.infra.repository;

import com.aws.classe3.infra.entity.Logs;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogRepository extends JpaRepository<Logs, Integer> {

}
