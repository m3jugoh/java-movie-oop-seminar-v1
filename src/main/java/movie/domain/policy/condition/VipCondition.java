package movie.domain.policy.condition;

import movie.domain.DiscountContext;

// VIP 조건
public class VipCondition implements DiscountCondition {
    @Override
    public boolean isSatisfiedBy(DiscountContext context) {
        return context.isCustomerVip();
    }
}
