package movie.domain.policy.condition;

import movie.domain.CustomerType;

// VipCondition은 이제 코드가 없는 선언적인 클래스가 된다.
public class VipCondition extends AbstractCustomerCondition {
    public VipCondition() {
        super(CustomerType.VIP);
    }
}
