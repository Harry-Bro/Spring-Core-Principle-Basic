package com.harrybro.core.beanfind;

import com.harrybro.core.AppConfig;
import com.harrybro.core.member.MemberService;
import com.harrybro.core.member.MemberServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ApplicationContextBasicFindTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("Seach by bean name")
    void seachByBeanName() {
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        assertTrue(memberService instanceof MemberServiceImpl);
    }

    @Test
    @DisplayName("Search only by type without bean name")
    void searchOnlyByTypeWithoutBeanName() {
        MemberService memberService = ac.getBean(MemberService.class);
        assertTrue(memberService instanceof MemberServiceImpl);
    }

    @Test
    @DisplayName("Search by concrete type")
    void searchByConcreteType() {
        MemberService memberService = ac.getBean(MemberServiceImpl.class);
        assertTrue(memberService instanceof MemberServiceImpl);
    }

}
