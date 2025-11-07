package movie.domain.policy;

import movie.domain.Money;
import movie.domain.policy.condition.DiscountCondition;

public class AmountDiscountPolicy<T> extends DefaultDiscountPolicy<T> {
    private final Money discountAmount;

    public AmountDiscountPolicy(Money discountAmount, DiscountCondition<T>... conditions) {
        super(conditions);
        this.discountAmount = discountAmount;
    }

    @Override
    protected Money getDiscountAmount(T t) {
        return discountAmount;
    }
}
