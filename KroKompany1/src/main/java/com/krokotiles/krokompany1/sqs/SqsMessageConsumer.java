package com.krokotiles.krokompany1.sqs;

import com.amazonaws.services.sqs.AmazonSQS;
import io.awspring.cloud.messaging.config.annotation.EnableSqs;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@EnableSqs
public class SqsMessageConsumer {

    private final AmazonSQS amazonSQS;

    @Autowired
    public SqsMessageConsumer(AmazonSQS amazonSQS) {
        this.amazonSQS = amazonSQS;
    }
}

