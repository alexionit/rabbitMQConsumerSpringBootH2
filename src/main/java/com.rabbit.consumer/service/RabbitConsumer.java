package com.rabbit.consumer.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbit.consumer.interfaceDAO.MessageRepo;
import com.rabbit.consumer.model.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.LinkedHashMap;
import java.util.concurrent.TimeUnit;

@Service
public class RabbitConsumer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private ApplicationContext appContext;


    private static final Logger logger = LoggerFactory.getLogger(RabbitConsumer.class);

    private static final String QUEUE_NAME = "receiver-queue-message";
    private static final String QUEUE_NAME2 = "topic-message";

//    @RabbitListener(queues = "#{autoDeleteQueue.name}")
//    public void receiveMessageFromQueue(String message) throws InterruptedException {
//        receive();
//    }
//    to be seen

    @Scheduled(fixedRate = 3000)
    public void receive()
    {
        Object object = rabbitTemplate.receiveAndConvert(QUEUE_NAME);

        if (object != null) {

            LinkedHashMap messReceived = (LinkedHashMap) object;

            ObjectMapper objectMapper = new ObjectMapper();
            Message pojoMessage = objectMapper.convertValue(messReceived, Message.class);

//            logger.info(" ID MESSAGE: [" + pojoMessage.getId() + "] ");
            logger.info(" CONTENT MESSAGE: [" + pojoMessage.getContent() + "] ");
            logger.info(" TIMESTAMP: [" + pojoMessage.getTimestamp() + "] ");
            logger.info(" Received: [" + pojoMessage.toString() + "] ");

            MessageRepo repo = appContext.getBean(MessageRepo.class);
            repo.save(new Message(pojoMessage.getContent(), pojoMessage.getTimestamp()));

            String messageUpload = pojoMessage.getContent();
            logger.info(" Uploaded into H2: [" + messageUpload + "] ");

        } else {
            Object objectQ2 = rabbitTemplate.receiveAndConvert(QUEUE_NAME2);

            if (objectQ2 != null) {

                LinkedHashMap messReceived2 = (LinkedHashMap) objectQ2;

                ObjectMapper objectMapper2 = new ObjectMapper();
                Message pojoMessage2 = objectMapper2.convertValue(messReceived2, Message.class);

//            logger.info(" ID MESSAGE: [" + pojoMessage.getId() + "] ");
                logger.info(" CONTENT MESSAGE: [" + pojoMessage2.getContent() + "] ");
                logger.info(" TIMESTAMP: [" + pojoMessage2.getTimestamp() + "] ");
                logger.info(" Received: [" + pojoMessage2.toString() + "] ");

                MessageRepo repo = appContext.getBean(MessageRepo.class);
                repo.save(new Message(pojoMessage2.getContent(), pojoMessage2.getTimestamp()));

                String messageUpload = pojoMessage2.getContent();
                logger.info(" Uploaded into H2: [" + messageUpload + "] ");

            }
        }

    }
}

