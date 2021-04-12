package com.rabbit.consumer.service;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.amqp.core.TopicExchange;


@SpringBootConfiguration
public class ServerConfig {

    static final String topicExchangeName = "receiver_topic_messages";
    static final String queueName = "receiver-queue-message";


    @Bean
    Queue queue() {
        return new Queue(queueName, true);
    }

    @Bean
    TopicExchange exchange() {
        return new TopicExchange(topicExchangeName);
    }

    @Bean
    Binding binding(Queue queue, TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with("*.newmessage.*");
    }








//    @Bean
//    SimpleMessageListenerContainer container(ConnectionFactory connectionFactory,
//                                             MessageListenerAdapter listenerAdapter) {
//        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
//        container.setConnectionFactory(connectionFactory);
//        container.setQueueNames(queueName);
//        container.setMessageListener(listenerAdapter);
//        return container;
//    }
//
//    @Bean
//    MessageListenerAdapter listenerAdapter(Receiver receivenew) {
//        return new MessageListenerAdapter(receivenew, "receiveMessage");
//    }



//    @Bean
//    public TopicExchange topic() {
//        return new TopicExchange("receiver_topic_messages");
//    }
//    @Profile("receiver")
//    private static class ReceiverConfig {
//
//        @Bean
//        public RabbitConsumer receiver() {
//            return new RabbitConsumer();
//        }
//
//        @Bean
//        public Queue autoDeleteQueue() {
////            return new AnonymousQueue();
//            String QUEUE_NAME = "receiver-queue-message";
//            return new Queue(QUEUE_NAME);
//        }
//
//
//        @Bean
//        public Binding bindingMessage(TopicExchange topic, Queue autoDeleteQueue) {
//
////            String EXCHANGE_NAME = "topic_logs_messages";
////            TopicExchange exchnage = new TopicExchange(EXCHANGE_NAME);
//
////            BindingBuilder.bind(queue).to(exchnage).with("*.message.*");
//            return BindingBuilder.bind(autoDeleteQueue).to(topic).with("*.message.*");
//        }
//
//    }

}
