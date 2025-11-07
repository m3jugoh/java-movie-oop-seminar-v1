package movie.domain.policy.condition;

import java.util.List;

import movie.domain.Ticket;

/**
 * 할인이 적용될 조건이 '무비데이(매월 10일, 20일, 30일)'인지를 판단하는 클래스.
 */

public class MovieDayCondition implements DiscountCondition {
    private final List<Integer> movieDays = List.of(10, 20, 30);

    @Override
    public boolean isSatisfiedBy(Ticket ticket) {
        return movieDays.contains(ticket.getWhenShowing().getDayOfMonth());
    }
}