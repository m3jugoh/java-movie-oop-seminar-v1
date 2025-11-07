package movie.domain.policy;

import java.util.List;

import movie.domain.Money;
import movie.domain.Ticket;
import movie.domain.policy.condition.DiscountCondition;

public abstract class DefaultDiscountPolicy implements DiscountPolicy {
    private final List<DiscountCondition> conditions;

    public DefaultDiscountPolicy(DiscountCondition... conditions) {
        this.conditions = List.of(conditions);
    }

    @Override
    public Money calculateDiscountAmount(Ticket ticket) {
        if (conditions.isEmpty() ||
                conditions.stream().anyMatch(cond -> cond.isSatisfiedBy(ticket))) {
            return getDiscountAmount(ticket);
        }
        return Money.ZERO;
    }

    protected abstract Money getDiscountAmount(Ticket ticket);
}
