package movie.domain.matchingbox;

import java.time.LocalTime;
import java.util.List;

import movie.domain.BothTimes;

public class BothTimesBox implements MatchingBox<LocalTime> {
    private final List<BothTimes> bothTimes;

    public BothTimesBox(BothTimes... bothTimes) {
        if (bothTimes == null) {
            throw new IllegalArgumentException("Discount times cannot be null");
        }
        this.bothTimes = List.of(bothTimes);
    }

    @Override
    public boolean match(LocalTime unit) {
        return bothTimes.stream().anyMatch(dt -> dt.isBetweenTimes(unit));
    }
}
