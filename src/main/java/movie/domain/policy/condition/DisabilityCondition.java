package movie.domain.policy.condition;

import movie.domain.DiscountContext;

// 장애인 조건
public class DisabilityCondition implements DiscountCondition {
    @Override
    public boolean isSatisfiedBy(DiscountContext context) {
        return context.isCustomerDisability();
    }
}

