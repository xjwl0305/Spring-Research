package hello.core.beanfind;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;

public class ApplicationContextBasicFindTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("빈 이름으로 조회")
    void findBeanByName() {
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        System.out.println("memberService ="+ memberService);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);

    }

    @Test
    @DisplayName("이름없으 타입으로만 조회")
    void findBeanByType() {
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        System.out.println("memberService ="+ memberService);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);

    }
    @Test
    @DisplayName("빈 이름으로 조회 X")
    void findBeanByNameX(){
        org.junit.jupiter.api.Assertions.assertThrows(NoSuchBeanDefinitionException.class,
                () -> ac.getBean("xxxx", MemberService.class));
    }
}
