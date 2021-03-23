package com.harrybro.core.beanfind;

import com.harrybro.core.member.MemberRepository;
import com.harrybro.core.member.MemoryMemberRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class ApplicationContextSameBeanFindTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SameBeanConfig.class);

    @Test
    @DisplayName("When searching by type, an error occurs if there are two or more types.")
    void whenSearchingByTypeAnErrorOccursIfThereAreTwoOrMoreTypes() {
        Assertions.assertThrows(NoUniqueBeanDefinitionException.class,
                () -> ac.getBean(MemberRepository.class));
    }

    @Test
    @DisplayName("If there are two or more of the same type, search by bean name.")
    void ifThereAreTwoOrMoreOfTheSameTypeSearchByBeanName() {
        MemberRepository memberRepository1 = ac.getBean("memberRepository1", MemberRepository.class);
        Assertions.assertTrue(memberRepository1 instanceof MemberRepository);

    }
    
    @Configuration
    static class SameBeanConfig {
        @Bean
        public MemberRepository memberRepository1() {
            return new MemoryMemberRepository();
        }

        @Bean
        public MemberRepository memberRepository2() {
            return new MemoryMemberRepository();
        }

    }

}
