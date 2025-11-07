package movie.domain.policy;

import movie.domain.Money;
import movie.domain.Ticket;
import movie.domain.policy.condition.DiscountCondition;

public class AmountDiscountPolicy extends DefaultDiscountPolicy {
    private final Money discountAmount;

    public AmountDiscountPolicy(Money discountAmount, DiscountCondition... conditions) {
        super(conditions);
        this.discountAmount = discountAmount;
    }

    @Override
    protected Money getDiscountAmount(Ticket ticket) {
        return discountAmount;
    }
}
