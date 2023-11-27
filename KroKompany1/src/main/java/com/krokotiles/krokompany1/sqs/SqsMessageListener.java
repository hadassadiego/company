package com.krokotiles.krokompany1.sqs;

import io.awspring.cloud.messaging.listener.annotation.SqsListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class SqsMessageListener {

    @SqsListener("${cloud.aws.sqs.endpoint}")
    public void queueListener(String message){
        log.info("Message received: {}.", message);
    }
}