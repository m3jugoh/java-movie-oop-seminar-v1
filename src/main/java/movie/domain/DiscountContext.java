package movie.domain;

import java.time.LocalDateTime;

public class DiscountContext {
    private final Customer customer;
    private final Showing showing;

    public DiscountContext(Customer customer, Showing showing) {
        this.customer = customer;
        this.showing = showing;
    }

    public boolean isCustomerDisability() {
        return customer.isDisability();
    }

    public boolean isCustomerVip() {
        return customer.isVip();
    }

    public LocalDateTime getWhenShowingMovie() {
        return showing.getWhenShowing();
    }

    public Money getMovieFee() {
        return showing.getMovieFee();
    }
}
