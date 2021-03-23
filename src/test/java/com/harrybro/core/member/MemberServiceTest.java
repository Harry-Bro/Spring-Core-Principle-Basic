package com.harrybro.core.member;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    MemberService memberService = new MemberServiceImpl();

    @Test
    @DisplayName("join test")
    void joinTest() {
        Member memberA = new Member(1L, "memberA", Grade.VIP);

        memberService.join(memberA);
        Member findMember = memberService.findMember(1L);

        assertEquals(memberA.getName(), findMember.getName());
    }

}