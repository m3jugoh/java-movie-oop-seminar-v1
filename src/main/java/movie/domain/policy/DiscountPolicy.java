package movie.domain.policy;

import movie.domain.Money;
import movie.domain.Ticket;

public interface DiscountPolicy {
    Money calculateDiscountAmount(Ticket ticket);
}
