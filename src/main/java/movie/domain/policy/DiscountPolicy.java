package movie.domain.policy;

import movie.domain.Money;

public interface DiscountPolicy<T> {
    Money calculateDiscountAmount(T t);
}
