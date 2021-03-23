package com.harrybro.core.order;

import com.harrybro.core.member.Grade;
import com.harrybro.core.member.Member;
import com.harrybro.core.member.MemberService;
import com.harrybro.core.member.MemberServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceTest {

    MemberService memberService = new MemberServiceImpl();
    OrderService orderService = new OrderServiceImpl();

    @Test
    @DisplayName("Create order test")
    void createOrderTest() {
        Member memberA = new Member(1L, "memberA", Grade.VIP);
        memberService.join(memberA);

        Order orderItemA = orderService.createOrder(1L, "itemA", 10000);
        assertEquals(orderItemA.getDiscountPrice(), 1000);
    }

}