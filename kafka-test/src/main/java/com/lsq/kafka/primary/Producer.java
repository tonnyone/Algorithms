package com.lsq.kafka.primary;

import org.apache.kafka.clients.producer.Callback;
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
        props.put("bootstrap.servers","192.168.200.219:19092");
        props.put("key.serializer","org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer","org.apache.kafka.common.serialization.StringSerializer");
        KafkaProducer producer = new KafkaProducer<String,String>(props);

        ProducerRecord<String,String> producerRecord = new ProducerRecord<String, String>("test","5","nihao5");
        //1. 直接发送
        producer.send(producerRecord);
        //2. 获取future,阻塞获取结果
        Future<RecordMetadata> future = producer.send(producerRecord);
        RecordMetadata recordMetadata = null;
        try {
            recordMetadata = future.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("发送成功"+recordMetadata.toString());
        //3. 成功后执行回调
        producer.send(producerRecord, new Callback() {
            public void onCompletion(RecordMetadata recordMetadata, Exception e) {
                System.out.println("发送成功CallBack:"+recordMetadata.toString());
            }
        });
    }
}
