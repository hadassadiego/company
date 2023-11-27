package com.krokotiles.krokompany1.sqs;

import io.awspring.cloud.messaging.core.QueueMessagingTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class SqsMessageService {

    private final String queueName;
    private final QueueMessagingTemplate queueMessagingTemplate;

    @Autowired
    public SqsMessageService(@Value("${cloud.aws.sqs.queueName}") String queueName, QueueMessagingTemplate queueMessagingTemplate) {
        this.queueName = queueName;
        this.queueMessagingTemplate = queueMessagingTemplate;

        this.receiveMessagesFromQueue();
    }

    private void receiveMessagesFromQueue() {
            while (true) {
                try {
                    String receivedMessage = queueMessagingTemplate.receiveAndConvert(queueName, String.class);

                    if (receivedMessage != null) {
                        System.out.println("Received message from queue: " + receivedMessage);
                    } else {
                        System.out.println("No messages in queue.");
                    }
                } catch (Exception ex) {
                    System.out.println("Error receiving message from queue: " + ex.getMessage());
                }
            }
        }
    }
