//
//import com.rabbit.consumer.RabbitRunConsumeMq;
//import com.rabbit.consumer.serviceDAO.MessageService;
//import org.junit.jupiter.api.Test;
//
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.support.AnnotationConfigContextLoader;
//
////@RunWith(SpringJUnit4ClassRunner.class)
////@SpringBootTest(classes= RabbitRunConsumeMq.class)
//@RunWith(SpringJUnit4ClassRunner.class)
//// ApplicationContext will be loaded from the static inner ContextConfiguration class
//@ContextConfiguration(loader= AnnotationConfigContextLoader.class)
//public class TestApplicationContext {
//
//    @Autowired
//    private MessageService messService;
//
//    @Test
//    public void contextLoads() {
//    }
//
//    @Configuration
//    static class ContextConfiguration {
//
//        // this bean will be injected into the OrderServiceTest class
//        @Bean
//        public MessageService messageService() {
//            MessageService messaService = new MessageService();
//            messaService.save();
//            messaService.getMessageBodyById(1);
//            return orderService;
//        }
//    }
//
//    @Autowired
//    private OrderService orderService;
//
//    @Test
//    public void testOrderService() {
//        // test the orderService
//    }
//}