package movie.service;

import movie.domain.Customer;
import movie.domain.DiscountContext;
import movie.domain.Money;
import movie.domain.Showing;
import movie.domain.policy.DiscountPolicy;

public class ReservationService {
    private final DiscountPolicyFactory policyFactory;

    public ReservationService(DiscountPolicyFactory policyFactory) {
        this.policyFactory = policyFactory;
    }

    public Money reserve(Customer customer, Showing showing) {
        DiscountPolicy finalPolicy = policyFactory.create();
        DiscountContext context = new DiscountContext(customer, showing);
        Money discountAmount = finalPolicy.calculateDiscountAmount(context);
        return showing.getMovieFee().minus(discountAmount);
    }
}
