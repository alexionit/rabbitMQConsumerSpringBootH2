package com.rabbit.consumer.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbit.consumer.interfaceDAO.MessageRepo;
import com.rabbit.consumer.model.Message;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;

@Service
public class RabbitConsumer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private ApplicationContext appContext;

    private static final Logger logger = LoggerFactory.getLogger(RabbitConsumer.class);

    private static final String QUEUE_NAME = "topic-message";

    @Scheduled(fixedRate = 5000)
    public void receive()
    {
        Object object = rabbitTemplate.receiveAndConvert(QUEUE_NAME);

        if (object != null) {
            LinkedHashMap messReceived = (LinkedHashMap) object;

            ObjectMapper objectMapper = new ObjectMapper();
            Message pojoMessage = objectMapper.convertValue(messReceived, Message.class);

            logger.info(" ID MESSAGE: [" + pojoMessage.getId() + "] ");
            logger.info(" CONTENT MESSAGE: [" + pojoMessage.getContent() + "] ");

            logger.info(" Received: [" + pojoMessage.toString() + "] ");

            String messageUpload = pojoMessage.getContent();
            MessageRepo repo = appContext.getBean(MessageRepo.class);
            repo.save(new Message(pojoMessage.getId(), pojoMessage.getContent()));
            logger.info(" Uploaded into H2: [" + messageUpload + "] ");

        }
    }
}

