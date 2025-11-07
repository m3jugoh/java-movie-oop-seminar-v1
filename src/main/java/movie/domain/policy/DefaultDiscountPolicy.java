package movie.domain.policy;

import java.util.List;

import movie.domain.Money;
import movie.domain.policy.condition.DiscountCondition;

public abstract class DefaultDiscountPolicy<T> implements DiscountPolicy<T> {
    private final List<DiscountCondition<T>> conditions;

    public DefaultDiscountPolicy(DiscountCondition<T>... conditions) {
        this.conditions = List.of(conditions);
    }

    @Override
    public Money calculateDiscountAmount(T t) {
        if (conditions.isEmpty() ||
                conditions.stream().anyMatch(cond -> cond.isSatisfiedBy(t))) {
            return getDiscountAmount(t);
        }
        return Money.ZERO;
    }

    protected abstract Money getDiscountAmount(T t);
}
