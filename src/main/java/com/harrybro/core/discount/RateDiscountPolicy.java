package com.harrybro.core.discount;

import com.harrybro.core.member.Grade;
import com.harrybro.core.member.Member;

public class RateDiscountPolicy implements DiscountPolicy {

    private int discountPercent = 10;

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade().equals(Grade.VIP))
            return price * discountPercent / 100;

        return 0;
    }
}
