package com.rabbit.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableAutoConfiguration
@ComponentScan
//@ComponentScan({"com.rabbit.consumer.controllerDAO", "com.rabbit.consumer.serviceDAO", "com.rabbit.consumer.service"}) //load bean from start
public class RabbitRunConsumeMq implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(RabbitRunConsumeMq.class);

    public static void main(String[] args) {
        SpringApplication.run(RabbitRunConsumeMq.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        logger.info(" trying to pull the messages from RabbitMQ server ");
    }
}
