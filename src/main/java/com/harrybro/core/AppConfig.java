package com.harrybro.core;

import com.harrybro.core.discount.DiscountPolicy;
import com.harrybro.core.discount.RateDiscountPolicy;
import com.harrybro.core.member.MemberRepository;
import com.harrybro.core.member.MemberService;
import com.harrybro.core.member.MemberServiceImpl;
import com.harrybro.core.member.MemoryMemberRepository;
import com.harrybro.core.order.OrderService;
import com.harrybro.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(getMemberRepository());
    }

    @Bean
    public MemberRepository getMemberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    OrderService orderService() {
        return new OrderServiceImpl(getMemberRepository(), getDiscountPolicy());
    }

    @Bean
    public DiscountPolicy getDiscountPolicy() {
        return new RateDiscountPolicy();
    }

}
