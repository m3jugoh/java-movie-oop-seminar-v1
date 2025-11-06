package movie.domain.policy;

import java.util.List;

import movie.domain.DiscountContext;
import movie.domain.Money;

public class OverlappedDiscountPolicy implements DiscountPolicy {
    private final List<DiscountPolicy> policies;

    public OverlappedDiscountPolicy(DiscountPolicy... policies) {
        this.policies = List.of(policies);
    }

    @Override
    public Money calculateDiscountAmount(DiscountContext context) {
        return policies.stream()
                .map(p -> p.calculateDiscountAmount(context))
                .reduce(Money.ZERO, Money::plus);
    }
}
