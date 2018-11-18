package com.lsq.kafka.primary;

import org.apache.kafka.clients.consumer.*;
import org.apache.kafka.common.TopicPartition;

import java.util.*;

/**
 * <p>Description: </p>
 * @author liushaoqing
 * @version 1.0
 * @date 2018-06-06
 */
public class Consumer{

    public static void main(String[] args) {
        Properties props = new Properties();
        props.put("bootstrap.servers","192.168.200.219:19092");
        props.put("group.id","testgroup2");
        props.put("key.deserializer","org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer","org.apache.kafka.common.serialization.StringDeserializer");

        KafkaConsumer<String,String> consumer = new KafkaConsumer<String,String>(props);
        consumer.subscribe(Arrays.asList("test"));// 1. 消费者订阅主题，此处一次订阅多个主题，或者可以使用正则表达式
        try{
            while (true){
                //2. 消费者必须持续向kafka轮询，否则就会被认为死亡。
                ConsumerRecords<String, String> cr = consumer.poll(100);
                for (ConsumerRecord<String, String> record : cr) {
                    System.out.printf("record:%s \n",record.toString());
                }
                consumer.commitAsync();
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            try{
                consumer.commitSync();
            }finally {
                //3.在退出程序之前使用close()方法关闭消费者。
                consumer.close();
            }
        }
    }
}
