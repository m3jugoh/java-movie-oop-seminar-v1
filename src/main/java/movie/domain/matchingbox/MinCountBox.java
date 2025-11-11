package movie.domain.matchingbox;

public class MinCountBox implements MatchingBox<Integer> {
    private final Integer minCount;

    public MinCountBox(Integer minCount) {
        this.minCount = minCount;
    }

    @Override
    public boolean match(Integer unit) {
        return minCount != null && unit >= minCount;
    }
}
