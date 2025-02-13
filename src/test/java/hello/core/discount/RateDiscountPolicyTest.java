package hello.core.discount;

import hello.core.AppConfig;
import hello.core.member.*;
import hello.core.order.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {
    RateDiscountPolicy rateDiscountPolicy = new RateDiscountPolicy();
    MemberService memberService;

    @BeforeEach
    public void beforeEach(){
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }


    @Test
    @DisplayName("VIP는 10% 할인이 되어야 한다.")
    void vip_o(){
        //given
        Member member = new Member(1L, "memberA", Grade.VIP);

        //when
        memberService.join(member);
        int discountPrice = rateDiscountPolicy.discount(member, 20000);

        //then
        assertThat(discountPrice).isEqualTo(2000);
    }

    @Test
    @DisplayName("VIP가 아닌 경우")
    void vip_x(){
        //given
        Member member = new Member(1L, "memberA", Grade.BASIC);

        //when
        memberService.join(member);
        int totalPrice = rateDiscountPolicy.discount(member, 20000);

        //then
        assertThat(totalPrice).isEqualTo(0);
    }

}