package com.csye6225.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;

import java.util.Properties;
//@Author Hiren

public class Producer {

    @Autowired
    private static Environment env;

    public static void produce(String payload){
        System.out.println("inside produce");
        String KAFKA_SERVICE_IP=System.getenv("KAFKA_SERVICE_IP");
        String KAFKA_SERVICE_PORT=System.getenv("KAFKA_SERVICE_PORT");
        String KAFKA_TOPIC_NAME=System.getenv("KAFKA_TOPIC_NAME");
        Properties producerProperties = new Properties();
        producerProperties.put("bootstrap.servers", KAFKA_SERVICE_IP+":"+KAFKA_SERVICE_PORT);
        producerProperties.put("acks", "all");
        producerProperties.put("retries", 0);
        producerProperties.put("batch.size", 16384);
        producerProperties.put("linger.ms", 1);
        producerProperties.put("buffer.memory", 33554432);
        producerProperties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        producerProperties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        KafkaProducer<String, String> producer = new KafkaProducer<>(producerProperties);
        sendKafkaMessage(payload,producer,KAFKA_TOPIC_NAME);
    }

    private static void sendKafkaMessage(String payload,
                                         KafkaProducer<String, String> producer,
                                         String topic)
    {
        System.out.println("Sending Kafka message: " + payload);
        producer.send(new ProducerRecord<>(topic, payload));
    }
}
