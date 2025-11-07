package movie.domain.policy.condition;

public interface DiscountCondition<T> {
    boolean isSatisfiedBy(T t);
}
