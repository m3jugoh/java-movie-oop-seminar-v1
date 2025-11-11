package movie.domain.matchingbox;

public interface MatchingBox<T> {
    boolean match(T unit);
}
