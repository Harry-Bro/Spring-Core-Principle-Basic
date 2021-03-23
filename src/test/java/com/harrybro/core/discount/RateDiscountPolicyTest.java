package com.harrybro.core.discount;

import com.harrybro.core.member.Grade;
import com.harrybro.core.member.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {

    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10퍼센트 할인이 적용되어야 한다")
    void vip는10퍼센트할인이적용되어야한다() {
        Member memberVip = new Member(1L, "memberVip", Grade.VIP);
        int discount = discountPolicy.discount(memberVip, 10000);
        assertEquals(1000, discount);
    }

    @Test
    @DisplayName("VIP가 아니면 할인이 적용되지 않아야한다")
    void vip가아니면할인이적용되지않아야한다() {
        Member member = new Member(1L, "memberVip", Grade.BASIC);
        int discount = discountPolicy.discount(member, 10000);
        assertEquals(0, discount);
        assertNotEquals(1000, discount);
    }

}