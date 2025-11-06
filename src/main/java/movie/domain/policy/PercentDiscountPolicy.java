package movie.domain.policy;

import movie.domain.DiscountContext;
import movie.domain.Money;
import movie.domain.policy.condition.DiscountCondition;

public class PercentDiscountPolicy extends DefaultDiscountPolicy {
    private final double percent;

    public PercentDiscountPolicy(double percent, DiscountCondition... conditions) {
        super(conditions);
        this.percent = percent;
    }

    @Override
    protected Money getDiscountAmount(DiscountContext context) {
        return context.getMovieFee().times(percent);
    }
}
