package movie.domain.policy;

import movie.domain.Money;
import movie.domain.Ticket;
import movie.domain.policy.condition.DiscountCondition;

public class PercentDiscountPolicy extends DefaultDiscountPolicy {
    private final double percent;

    public PercentDiscountPolicy(double percent, DiscountCondition... conditions) {
        super(conditions);
        this.percent = percent;
    }

    @Override
    protected Money getDiscountAmount(Ticket ticket) {
        return ticket.getMovieFee().times(percent);
    }
}
