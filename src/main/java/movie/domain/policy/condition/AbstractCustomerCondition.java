package movie.domain.policy.condition; // 패키지 세분화

import movie.domain.CustomerType;
import movie.domain.Ticket;

// '고객'에 대한 할인을 판단하는 모든 조건의 추상 클래스
public abstract class AbstractCustomerCondition implements DiscountCondition<Ticket> {
    private final CustomerType typeCondition;

    public AbstractCustomerCondition(CustomerType typeCondition) {
        this.typeCondition = typeCondition;
    }

    @Override
    public boolean isSatisfiedBy(Ticket ticket) {
        // Ticket을 통해 Customer 타입 매칭을 요청한다.
        return ticket.isMatchCustomer(this.typeCondition);
    }
}
