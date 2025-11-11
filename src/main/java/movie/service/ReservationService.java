package movie.service;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

import movie.domain.BothTimes;
import movie.domain.Customer;
import movie.domain.Money;
import movie.domain.Showing;
import movie.domain.Theater;
import movie.domain.Ticket;
import movie.domain.Tickets;
import movie.domain.matchingbox.BothTimesBox;
import movie.domain.matchingbox.MinCountBox;
import movie.domain.matchingbox.MovieDayBox;
import movie.domain.policy.DiscountPolicy;

public class ReservationService {
    private final Theater theater;
    private final DiscountPolicyFactory policyFactory;

    public ReservationService(Theater theater, DiscountPolicyFactory policyFactory) {
        this.theater = theater;
        this.policyFactory = policyFactory;
        theater.setMovieDayBox(new MovieDayBox(10, 20, 30));
        theater.setDiscountableTimeBox(new BothTimesBox(
                new BothTimes(theater.getStartTime(), LocalTime.of(11, 0)),
                new BothTimes(LocalTime.of(20, 0), theater.getEndTime())));
    }

    public Money reserve(Customer customer, Showing... showings) {
        return reserve(customer, Arrays.asList(showings));
    }

    public Money reserve(Customer customer, List<Showing> showings) {
        DiscountPolicy<Ticket> finalPolicy = policyFactory.createCustomerWithDefaultPolicy();
        DiscountPolicy<Tickets> groupDiscountPolicy = policyFactory.createGroupDiscountPolicy();
        MinCountBox groupMinCountBox = new MinCountBox(4);
        return new Tickets(showings.stream()
                .map(showing -> new Ticket(customer, showing, theater, finalPolicy))
                .toList(), groupDiscountPolicy)
                .setGroupMinCount(groupMinCountBox)
                .calculateTotalFee();
    }
}
