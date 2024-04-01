package com.hyewon.kafkastreams.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.errors.LogAndContinueExceptionHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafkaStreams;
import org.springframework.kafka.config.KafkaStreamsConfiguration;

import java.util.List;
import java.util.Map;

@Slf4j
@EnableKafkaStreams
@Configuration
public class KafkaStreamsConfig {

    private List<String> bootstrapServers = List.of("localhost:9092");
    private String applicationId = "kafka-streams-application";

    public KafkaStreamsConfiguration kafkaStreamsConfig() {
        Map<String, Object> props = Map.of(
                StreamsConfig.APPLICATION_ID_CONFIG, applicationId,
                StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers,
                StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName(),
                StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName(),
                StreamsConfig.COMMIT_INTERVAL_MS_CONFIG, 1000,
                StreamsConfig.DEFAULT_DESERIALIZATION_EXCEPTION_HANDLER_CLASS_CONFIG, LogAndContinueExceptionHandler.class.getName()
        );

        return new KafkaStreamsConfiguration(props);
    }

}
