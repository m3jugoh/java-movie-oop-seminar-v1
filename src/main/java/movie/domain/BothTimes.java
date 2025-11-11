package movie.domain;

import java.time.LocalTime;

public class BothTimes {
    private final LocalTime startTime;
    private final LocalTime endTime;

    public BothTimes(LocalTime startTime, LocalTime endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public boolean isBetweenTimes(LocalTime time) {
        return (time.equals(startTime) || time.isAfter(startTime)) && time.isBefore(endTime);
    }
}
