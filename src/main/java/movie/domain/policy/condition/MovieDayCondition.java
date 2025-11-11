package movie.domain.policy.condition;

import movie.domain.Ticket;

/**
 * 할인이 적용될 조건이 '무비데이(매월 10일, 20일, 30일)'인지를 판단하는 클래스.
 */

public class MovieDayCondition implements DiscountCondition<Ticket> {
    @Override
    public boolean isSatisfiedBy(Ticket t) {
        return t.isMovieDay();
    }
}