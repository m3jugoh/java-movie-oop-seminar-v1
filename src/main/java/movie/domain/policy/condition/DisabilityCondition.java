package movie.domain.policy.condition;

import movie.domain.Ticket;

// 장애인 조건
public class DisabilityCondition implements DiscountCondition<Ticket> {
    @Override
    public boolean isSatisfiedBy(Ticket t) {
        return t.isCustomerDisability();
    }
}

