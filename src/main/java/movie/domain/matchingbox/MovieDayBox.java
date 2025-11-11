package movie.domain.matchingbox;

import java.util.Set;

public class MovieDayBox implements MatchingBox<Integer> {
    private final Set<Integer> movieDays;

    public MovieDayBox(Integer... movieDays) {
        if (movieDays == null) {
            throw new IllegalArgumentException("Movie days cannot be null");
        }
        this.movieDays = Set.of(movieDays);
    }

    @Override
    public boolean match(Integer unit) {
        return movieDays.contains(unit);
    }
}
