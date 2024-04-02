package com.hyewon.kafkastreams.config;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing
@RequiredArgsConstructor
public class JpaConfig {

    private final EntityManager entityManager;
}
