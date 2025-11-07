package movie.domain.policy;

import movie.domain.Money;
import movie.domain.Tickets;
import movie.domain.policy.condition.DiscountCondition;

public class TicketsPercentDiscountPolicy extends PercentDiscountPolicy<Tickets> {
    public TicketsPercentDiscountPolicy(double percent, DiscountCondition<Tickets>... conditions) {
        super(percent, conditions);
    }

    @Override
    protected Money getOriginalAmount(Tickets tickets) {
        return tickets.totalFee();
    }
}
