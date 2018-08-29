## Kafka Consumer实例
1. 导入Kafka官方Documentation的第2章，导入Producer的pom依赖，参考javadoc的提示，书写如下代码
```
package com.github.memorylorry;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

public class ProducerDemo {
    Properties props = new Properties();
    public ProducerDemo(){
        props.put("bootstrap.servers", "192.168.32.141:9091,192.168.32.141:9092,192.168.32.141:9093");
        props.put("acks", "all");
        props.put("retries", 0);
        props.put("batch.size", 16384);
        props.put("linger.ms", 1);
        props.put("buffer.memory", 33554432);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
    }

    public static void main(String[] args){
        ProducerDemo demo = new ProducerDemo();
        //设置主题
        String topic = "mark";

        KafkaProducer<String, String> producer = new KafkaProducer<String, String>(demo.props);

        for (int i = 0; i < 100; i++) {
            //计算分区号
            int partion = i%2;
            producer.send(new ProducerRecord<String, String>(topic, partion, Integer.toString(i), Integer.toString(i)));
        }

        producer.close();
    }
}
```