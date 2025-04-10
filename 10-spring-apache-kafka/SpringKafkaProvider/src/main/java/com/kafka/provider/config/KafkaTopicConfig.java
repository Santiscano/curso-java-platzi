package com.kafka.provider.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.common.config.TopicConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic generateTopic() {

        Map<String, String> configurations = new HashMap<>(); // un hashMap es un tipo de coleccion que almacena datos en pares clave-valor, es similar a un diccionario en python
        configurations.put(TopicConfig.CLEANUP_POLICY_CONFIG, TopicConfig.CLEANUP_POLICY_DELETE); // delete (borra mensaje) - compact (Mantiene el mas actual)
        configurations.put(TopicConfig.RETENTION_MS_CONFIG, "86400000"); // Tiempo de retencion de mensajes, defecto -1 es decir no se borran, este debe indicarse en milisegundos
        configurations.put(TopicConfig.SEGMENT_BYTES_CONFIG, "1073741824"); // Tamanio maximo del segmento - defecto 1073741824 bytes - 1GB
        configurations.put(TopicConfig.MAX_MESSAGE_BYTES_CONFIG, "1000012"); // Tamanio maximo de cada mensaje - defecto 1000000 - 1 MB

        NewTopic newTopic = TopicBuilder.name("topic-name") // nombre el topic
                .partitions(2) // Numero de particiones
                .replicas(2) // Numero de replicas
                .configs(configurations) // Configuraciones adicionales, como el tiempo de retencion de mensajes
                .build(); // indicacion final para construir el topic

        return newTopic;
    }
}