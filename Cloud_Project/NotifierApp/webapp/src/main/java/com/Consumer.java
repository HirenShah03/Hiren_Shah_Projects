package com;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;

import java.util.*;
//@Author Hiren
public class Consumer {
    @Autowired
    private static Environment env;


    public static void main(String[] args) {

        final String TOPIC_NAME = "csye7374";
         String KAFKA_SERVICE_IP =System.getenv("KAFKA_SERVICE_IP");
         String KAFKA_SERVICE_PORT =System.getenv("KAFKA_SERVICE_PORT");
        if(KAFKA_SERVICE_IP==null || KAFKA_SERVICE_PORT==null){
            KAFKA_SERVICE_IP="127.0.0.1";
            KAFKA_SERVICE_PORT="9092";
        }
        System.out.println(KAFKA_SERVICE_IP+" :IP "+KAFKA_SERVICE_PORT+" :port");
        Properties props = new Properties();
        props.put("bootstrap.servers", KAFKA_SERVICE_IP+":"+KAFKA_SERVICE_PORT);
        props.put("group.id", "MyGroupId");
        props.put("enable.auto.commit", "false");
        props.put("auto.commit.interval.ms", "1000");
        props.put("auto.offset.reset", "latest");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");


        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);
        consumer.subscribe(Arrays.asList(TOPIC_NAME));
        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(100);
            for (ConsumerRecord<String, String> record : records) {
                System.out.printf("offset = %s, key = %s, value = %s \n", record.offset(), record.key(), record.value());
                AWSSender.sendData(record.value());
            }
        }
    }

}
