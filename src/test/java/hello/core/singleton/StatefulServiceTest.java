package hello.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableMBeanExport;

public class StatefulServiceTest {

    @Test
    void statefulServiceSingleton(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService state1 = ac.getBean(StatefulService.class);
        StatefulService state2 = ac.getBean(StatefulService.class);

        int userPrice = state1.order("userA", 10000);
        int userPrice2 = state1.order("userB", 20000);

        //int price = state1.getPrice();
        System.out.println("price = " + userPrice);

        //Assertions.assertThat(state1.getPrice()).isEqualTo(20000);
    }
    static class TestConfig {

        @Bean
        public StatefulService statefulService(){
            return new StatefulService();
        }
    }
}
