package movie.service;

import movie.domain.Money;
import movie.domain.Ticket;
import movie.domain.Tickets;
import movie.domain.policy.AmountDiscountPolicy;
import movie.domain.policy.DiscountPolicy;
import movie.domain.policy.OverlappedDiscountPolicy;
import movie.domain.policy.PickOnePolicy;
import movie.domain.policy.TicketPercentDiscountPolicy;
import movie.domain.policy.TicketsPercentDiscountPolicy;
import movie.domain.policy.condition.DisabilityCondition;
import movie.domain.policy.condition.GroupCountCondition;
import movie.domain.policy.condition.MovieDayCondition;
import movie.domain.policy.condition.TimeCondition;
import movie.domain.policy.condition.VipCondition;

public class DiscountPolicyFactory {
    public DiscountPolicy<Ticket> createCustomerWithDefaultPolicy() {
        // --- 1. 기본 부품 정의 ---
        DiscountPolicy<Ticket> disabilityPolicy = new TicketPercentDiscountPolicy(0.3, new DisabilityCondition()); // 장애인 30% 할인
        DiscountPolicy<Ticket> vipPolicy = new AmountDiscountPolicy<>(Money.wons(1000), new VipCondition()); // VIP 1000원 할인

        // --- 2. 규칙 조립: 규칙 1(장애인혜택) = Max(장애인, 기본중복) ---
        DiscountPolicy<Ticket> benefit1 =
                new PickOnePolicy<>(disabilityPolicy, createDefaultPolicy());

        // --- 3. 규칙 조립: 규칙 2(VIP혜택) = 기본중복 + VIP추가 ---
        DiscountPolicy<Ticket> benefit2 =
                new OverlappedDiscountPolicy<>(createDefaultPolicy(), vipPolicy);

        // --- 4. 최종 정책 조립: 규칙 3 = Max(규칙1, 규칙2) ---
        return new PickOnePolicy<>(benefit1, benefit2);
    }

    public DiscountPolicy<Ticket> createDefaultPolicy() {
        return new OverlappedDiscountPolicy<>(
                new TicketPercentDiscountPolicy(0.1, new MovieDayCondition()), // 영화의 날 10% 할인
                new AmountDiscountPolicy<>(Money.wons(2000), new TimeCondition())
                // 조조/심야 2000원 할인
        );
    }

    public DiscountPolicy<Tickets> createGroupDiscountPolicy() {
        return new TicketsPercentDiscountPolicy(0.1, new GroupCountCondition());
    }
}
