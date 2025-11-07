package movie.domain.policy;

import java.util.List;

import movie.domain.Money;

public class OverlappedDiscountPolicy<T> implements DiscountPolicy<T> {
    private final List<DiscountPolicy<T>> policies;

    public OverlappedDiscountPolicy(DiscountPolicy<T>... policies) {
        this.policies = List.of(policies);
    }

    @Override
    public Money calculateDiscountAmount(T t) {
        return policies.stream()
                .map(p -> p.calculateDiscountAmount(t))
                .reduce(Money.ZERO, Money::plus);
    }
}
