package movie.domain.policy.condition;

import movie.domain.Ticket;

/**
 * 할인이 적용될 조건이 '특정 시간대(조조, 심야)'인지를 판단하는 클래스.
 */

public class DiscountableTimeCondition implements DiscountCondition<Ticket> {
    @Override
    public boolean isSatisfiedBy(Ticket t) {
        return t.isDiscountableTime();
    }
}
