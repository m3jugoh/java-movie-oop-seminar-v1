package movie.domain.policy.condition;

import movie.domain.CustomerType;

public class DisabilityCondition extends AbstractCustomerCondition {
    public DisabilityCondition() {
        super(CustomerType.DISABILITY);
    }
}

