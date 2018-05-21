package com.lsq.kafka.primary;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.Properties;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * Created by tonny on 2018/5/21.
 */
public class Producer {

    public static void main(String[] args) {
        Properties props = new Properties();
        props.put("bootstrap.servers","192.168.200.219:9092");
        props.put("key.serializer","org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer","org.apache.kafka.common.serialization.StringSerializer");
        KafkaProducer producer = new KafkaProducer<String,String>(props);

        String topic = "test";
        ProducerRecord<String,String> producerRecord = new ProducerRecord<String, String>(topic,"1","nihao");
        Future<RecordMetadata> future = null;
        try{
            future = producer.send(producerRecord);
        }catch (Exception e){
            e.printStackTrace();
        }
        RecordMetadata recordMetadata = null;
        try {
            recordMetadata = future.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println(recordMetadata.toString());

    }
}
