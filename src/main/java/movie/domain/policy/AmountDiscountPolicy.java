package movie.domain.policy;

import movie.domain.DiscountContext;
import movie.domain.Money;
import movie.domain.policy.condition.DiscountCondition;

public class AmountDiscountPolicy extends DefaultDiscountPolicy {
    private final Money discountAmount;

    public AmountDiscountPolicy(Money discountAmount, DiscountCondition... conditions) {
        super(conditions);
        this.discountAmount = discountAmount;
    }

    @Override
    protected Money getDiscountAmount(DiscountContext context) {
        return discountAmount;
    }
}
