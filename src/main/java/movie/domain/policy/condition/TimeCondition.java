package movie.domain.policy.condition;

import java.time.LocalTime;

import movie.domain.DiscountContext;

/**
 * 할인이 적용될 조건이 '특정 시간대(조조, 심야)'인지를 판단하는 클래스.
 */

public class TimeCondition implements DiscountCondition {
    private static final LocalTime MORNING_END_TIME = LocalTime.of(11, 0);
    private static final LocalTime NIGHT_START_TIME = LocalTime.of(20, 0);

    @Override
    public boolean isSatisfiedBy(DiscountContext context) {
        LocalTime screeningTime = context.getWhenShowingMovie().toLocalTime();
        return screeningTime.isBefore(MORNING_END_TIME) || !screeningTime.isBefore(NIGHT_START_TIME);
    }
}
