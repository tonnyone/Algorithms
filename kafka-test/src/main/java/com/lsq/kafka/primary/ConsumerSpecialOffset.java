package com.lsq.kafka.primary;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.consumer.OffsetAndMetadata;
import org.apache.kafka.common.TopicPartition;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * <p>Description: </p>
 * @author liushaoqing
 * @version 1.0
 * @date 2018-06-06
 */
public class ConsumerSpecialOffset {

    public static void main(String[] args) {
        Properties props = new Properties();
        props.put("bootstrap.servers","192.168.200.219:19092");
        props.put("group.id","testgroup2");
        props.put("key.deserializer","org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer","org.apache.kafka.common.serialization.StringDeserializer");

        KafkaConsumer<String,String> consumer = new KafkaConsumer<String,String>(props);
        consumer.subscribe(Arrays.asList("test"));// 1. 消费者订阅主题，此处一次订阅多个主题，或者可以使用正则表达式

        // 1. 用于跟踪各个分区的偏移量
        Map<TopicPartition,OffsetAndMetadata> currentOffsets = new HashMap();
        int count=0;
        try{
            while (true){
                //2. 消费者必须持续向kafka轮询，否则就会被认为死亡
                ConsumerRecords<String, String> cr = consumer.poll(100);
                for (ConsumerRecord<String, String> record : cr) {
                    System.out.printf("record:%s \n",record.toString());
                    currentOffsets.put(new TopicPartition(record.topic(),record.partition()),new OffsetAndMetadata(record.offset()+1,"no metadata"));
                    // 3. 如果消费数量到1000 就提交偏移量
                    if(count % 1000==0){
                        consumer.commitAsync();
                    }
                    count++;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //4.在退出程序之前使用close()方法关闭消费者。
            consumer.close();
        }
    }
}
