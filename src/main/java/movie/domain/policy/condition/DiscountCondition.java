package movie.domain.policy.condition;

import movie.domain.Ticket;

public interface DiscountCondition {
    boolean isSatisfiedBy(Ticket ticket);
}
