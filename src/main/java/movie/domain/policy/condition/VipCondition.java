package movie.domain.policy.condition;

import movie.domain.Ticket;

// VIP 조건
public class VipCondition implements DiscountCondition {
    @Override
    public boolean isSatisfiedBy(Ticket ticket) {
        return ticket.isCustomerVip();
    }
}
