package movie.domain;

import java.time.LocalDateTime;

public class Showing {
    private final Movie movie;
    private final LocalDateTime whenShowing;

    public Showing(Movie movie, LocalDateTime whenShowing) {
        this.movie = movie;
        this.whenShowing = whenShowing;
    }

    public Movie getMovie() {
        return movie;
    }

    public LocalDateTime getWhenShowing() {
        return whenShowing;
    }

    public Money getMovieFee() {
        return movie.getFee();
    }
}
