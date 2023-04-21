package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{ // 주문서비스에 대한 구현체를 정의함

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    private final MemberRepository memberRepository; // 구성원 정보 객체호출
    private final DiscountPolicy discountPolicy;
    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {// 새로운 주문 생성시, 돌아갈 class 함수
        Member member = memberRepository.findById(memberId); // memberId에 해당하는 구성원 호출
        int discountPrice = discountPolicy.discount(member, itemPrice); // 구성원과 주문할 아이템의 가격을 입력받아 할인할 금액 output
        return new Order(memberId, itemName, itemPrice, discountPrice); // 주문 객체 생성 및 리턴
    }
}
