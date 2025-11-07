package movie.domain.policy.condition;

import movie.domain.Ticket;

// VIP 조건
public class VipCondition implements DiscountCondition<Ticket> {
    @Override
    public boolean isSatisfiedBy(Ticket t) {
        return t.isCustomerVip();
    }
}
