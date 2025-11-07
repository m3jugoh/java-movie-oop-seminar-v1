package movie.service;

import java.util.Arrays;
import java.util.List;

import movie.domain.Customer;
import movie.domain.Money;
import movie.domain.Showing;
import movie.domain.Ticket;
import movie.domain.Tickets;
import movie.domain.policy.DiscountPolicy;

public class ReservationService {
    private final DiscountPolicyFactory policyFactory;

    public ReservationService(DiscountPolicyFactory policyFactory) {
        this.policyFactory = policyFactory;
    }

    public Money reserve(Customer customer, Showing... showings) {
        return reserve(customer, Arrays.asList(showings));
    }

    public Money reserve(Customer customer, List<Showing> showings) {
        DiscountPolicy<Ticket> finalPolicy = policyFactory.createCustomerWithDefaultPolicy();
        DiscountPolicy<Tickets> groupDiscountPolicy = policyFactory.createGroupDiscountPolicy();
        return new Tickets(showings.stream()
                .map(showing -> new Ticket(customer, showing, finalPolicy))
                .toList(), groupDiscountPolicy).calculateTotalFee();
    }
}
