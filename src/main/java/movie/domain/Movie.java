package movie.domain;

import java.time.Duration;

public class Movie {
    private final String title;
    private final Duration runningTime;
    private final Money fee;

    public Movie(String title, Duration runningTime, Money fee) {
        this.title = title;
        this.runningTime = runningTime;
        this.fee = fee;
    }

    public Money getFee() {
        return fee;
    }
}
