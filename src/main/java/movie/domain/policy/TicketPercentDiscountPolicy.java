package movie.domain.policy;

import movie.domain.Money;
import movie.domain.Ticket;
import movie.domain.policy.condition.DiscountCondition;

public class TicketPercentDiscountPolicy extends PercentDiscountPolicy<Ticket> {

    public TicketPercentDiscountPolicy(double percent, DiscountCondition<Ticket>... conditions) {
        super(percent, conditions);
    }

    @Override
    protected Money getOriginalAmount(Ticket ticket) {
        return ticket.getMovieFee();
    }
}
