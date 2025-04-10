package com.kafka.consumer.config;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaConsumerConfig {

    @Value("${spring.kafka.bootstrapServers}")
    private String bootstrapServers;


    public Map<String, Object> consumerConfig(){
        Map<String, Object> properties = new HashMap<>();
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers); // este es el servidor de kafka
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringSerializer.class); // este se encarga de deserializar la clave del mensaje que se envia al topic
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringSerializer.class); // este se encarga de deserializar el valor del mensaje que se envia al topic
        return properties;
    }

    @Bean
    public ConsumerFactory<String, String> consumerFactory(){ // se crea un consumidor de kafka con las propiedades configuradas en consumerConfig
        return new DefaultKafkaConsumerFactory<>(consumerConfig()); // se crea un consumidor de kafka con las propiedades configuradas
    }

    @Bean
    public KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String, String>> consumer(ConsumerFactory consumerFactory) { // se crea un listener de kafka con las propiedades configuradas en consumerFactory y se le pasa el consumidor de kafka como parametro para que lo gestione spring
        ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<>(); // se crea un listener de kafka con las propiedades configuradas en consumerFactory y se le pasa el consumidor de kafka como parametro para que lo gestione spring
        factory.setConsumerFactory(consumerFactory);
        return factory;
    }
}
