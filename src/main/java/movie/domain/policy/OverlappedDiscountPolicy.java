package movie.domain.policy;

import java.util.List;

import movie.domain.Money;
import movie.domain.Ticket;

public class OverlappedDiscountPolicy implements DiscountPolicy {
    private final List<DiscountPolicy> policies;

    public OverlappedDiscountPolicy(DiscountPolicy... policies) {
        this.policies = List.of(policies);
    }

    @Override
    public Money calculateDiscountAmount(Ticket ticket) {
        return policies.stream()
                .map(p -> p.calculateDiscountAmount(ticket))
                .reduce(Money.ZERO, Money::plus);
    }
}
