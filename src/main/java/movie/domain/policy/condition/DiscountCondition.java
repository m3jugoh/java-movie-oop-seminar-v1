package movie.domain.policy.condition;

import movie.domain.DiscountContext;

public interface DiscountCondition {
    boolean isSatisfiedBy(DiscountContext context);
}
