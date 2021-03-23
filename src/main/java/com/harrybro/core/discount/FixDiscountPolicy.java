package com.harrybro.core.discount;

import com.harrybro.core.member.Grade;
import com.harrybro.core.member.Member;

public class FixDiscountPolicy implements DiscountPolicy {

    private int discountFixAmount = 1000;

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade().equals(Grade.VIP))
            return discountFixAmount;

        return 0;
    }
}
