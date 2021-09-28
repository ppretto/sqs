package com.sqs.aws.consumer;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@Log
public class ConsumerListener {


    private ObjectMapper objectMapper;

    @Autowired
    public ConsumerListener(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }


    @JmsListener(destination = "${aws.sqs.queue.product.events.name}")
    public void messageConsumer(@Headers Map<String, Object> messageAttributes,
                                @Payload String message) {
        log.info("Messages attributes: " + messageAttributes);
        log.info("Body: " + message);

    }

}
