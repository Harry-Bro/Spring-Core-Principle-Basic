package com.harrybro.core.order;

import com.harrybro.core.discount.DiscountPolicy;
import com.harrybro.core.discount.FixDiscountPolicy;
import com.harrybro.core.member.Member;
import com.harrybro.core.member.MemberRepository;
import com.harrybro.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
