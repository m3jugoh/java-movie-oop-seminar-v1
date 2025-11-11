package movie.domain;

import java.time.LocalDateTime;
import java.time.LocalTime;

import movie.domain.matchingbox.BothTimesBox;
import movie.domain.matchingbox.MovieDayBox;

public class Theater {
    private final LocalTime startTime;
    private final LocalTime endTime;
    private MovieDayBox movieDayBox = new MovieDayBox();
    private BothTimesBox discountableTimesBox = new BothTimesBox();

    public Theater(LocalTime startTime, LocalTime endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setMovieDayBox(MovieDayBox movieDayBox) {
        this.movieDayBox = movieDayBox;
    }

    public void setDiscountableTimeBox(BothTimesBox bothTimesBox) {
        this.discountableTimesBox = bothTimesBox;
    }

    public boolean isMovieDay(LocalDateTime whenShowing) {
        return movieDayBox.match(whenShowing.getDayOfMonth());
    }

    public boolean isDiscountableTime(LocalDateTime whenShowing) {
        return discountableTimesBox.match(whenShowing.toLocalTime());
    }
}
