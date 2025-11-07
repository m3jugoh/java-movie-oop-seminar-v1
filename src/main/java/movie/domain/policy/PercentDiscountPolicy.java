package movie.domain.policy;

import movie.domain.Money;
import movie.domain.policy.condition.DiscountCondition;

public abstract class PercentDiscountPolicy<T> extends DefaultDiscountPolicy<T> {
    private final double percent;

    public PercentDiscountPolicy(double percent, DiscountCondition<T>... conditions) {
        super(conditions);
        this.percent = percent;
    }

    @Override
    protected Money getDiscountAmount(T t) {
        return getOriginalAmount(t).times(percent);
    }

    abstract protected Money getOriginalAmount(T t);
}
