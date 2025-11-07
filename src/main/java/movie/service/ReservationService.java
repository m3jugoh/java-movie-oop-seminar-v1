package movie.service;

import movie.domain.Customer;
import movie.domain.Money;
import movie.domain.Showing;
import movie.domain.Ticket;
import movie.domain.policy.DiscountPolicy;

public class ReservationService {
    private final DiscountPolicyFactory policyFactory;

    public ReservationService(DiscountPolicyFactory policyFactory) {
        this.policyFactory = policyFactory;
    }

    public Money reserve(Customer customer, Showing showing) {
        DiscountPolicy finalPolicy = policyFactory.createCustomerWithDefaultPolicy();
        Ticket ticket = new Ticket(customer, showing, finalPolicy);
        return ticket.calculateFee();
    }
}
