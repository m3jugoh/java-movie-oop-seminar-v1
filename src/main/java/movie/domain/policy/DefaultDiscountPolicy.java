package movie.domain.policy;

import java.util.List;

import movie.domain.DiscountContext;
import movie.domain.Money;
import movie.domain.policy.condition.DiscountCondition;

public abstract class DefaultDiscountPolicy implements DiscountPolicy {
    private final List<DiscountCondition> conditions;

    public DefaultDiscountPolicy(DiscountCondition... conditions) {
        this.conditions = List.of(conditions);
    }

    @Override
    public Money calculateDiscountAmount(DiscountContext context) {
        if (conditions.isEmpty() ||
                conditions.stream().anyMatch(cond -> cond.isSatisfiedBy(context))) {
            return getDiscountAmount(context);
        }
        return Money.ZERO;
    }

    protected abstract Money getDiscountAmount(DiscountContext context);
}
