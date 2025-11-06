package movie.domain.policy;

import movie.domain.DiscountContext;
import movie.domain.Money;

public interface DiscountPolicy {
    Money calculateDiscountAmount(DiscountContext context);
}
