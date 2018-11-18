package com.lsq.kafka.primary;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.consumer.OffsetAndMetadata;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.common.errors.WakeupException;

import java.util.*;

/**
 * <p>Description: </p>
 * @author liushaoqing
 * @version 1.0
 * @date 2018-06-06
 */
public class ConsumerRebalanceListener {

    private static Properties props = new Properties();
    static {
        props.put("bootstrap.servers","192.168.200.219:19092");
        props.put("group.id","testgroup2");
        props.put("key.deserializer","org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer","org.apache.kafka.common.serialization.StringDeserializer");
    }
    // 1. 用于跟踪各个分区的偏移量
    private static Map<TopicPartition,OffsetAndMetadata> currentOffsets = new HashMap();
    private static KafkaConsumer<String,String> consumer = new KafkaConsumer<String,String>(props);

    public static void main(String[] args) {

        // 1. 注册再均衡监听器
        consumer.subscribe(Arrays.asList("test"),new HandleRebalance());
        int count=0;
        try{
            while (true){
                //2. 消费者必须持续向kafka轮询，否则就会被认为死亡
                ConsumerRecords<String, String> cr = consumer.poll(100);
                for (ConsumerRecord<String, String> record : cr) {
                    System.out.printf("record:%s \n",record.toString());
                    currentOffsets.put(new TopicPartition(record.topic(),record.partition()),new OffsetAndMetadata(record.offset()+1,"no metadata"));
                }
                consumer.commitAsync(currentOffsets,null);
            }
        }catch (WakeupException e){
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                //3.在退出程序之前使用close()方法关闭消费者。
                consumer.commitSync(currentOffsets);
            }finally {
                consumer.close();
                System.out.println("consumer has been Closed");
            }
        }
    }

    // 4. 实现ConsumerRebalanceListener 接口,实现消费者再均衡监听器
    private static class HandleRebalance implements org.apache.kafka.clients.consumer.ConsumerRebalanceListener{
        //5. 方法会在再均衡开始之前和消费者停止读取消息之后被调用,在这里提交已经读取的偏移量，下一个接管分区的消费者就会继续从这里开始读取
        public void onPartitionsRevoked(Collection<TopicPartition> partitions) {
            System.out.println("Lost paritions in rebalance,commit current offset"+currentOffsets);
            consumer.commitSync(currentOffsets);
        }

        // 6. 方法会在在均衡之后，就是重新分配分区之后，新的消费者开始读取消息之前被调用
        public void onPartitionsAssigned(Collection<TopicPartition> partitions) {

        }
    }
}
