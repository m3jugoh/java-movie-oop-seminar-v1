package movie.domain;

import java.time.LocalDateTime;

import movie.domain.policy.DiscountPolicy;

public class Ticket {
    private final Customer customer;
    private final Showing showing;
    private final Theater theater;
    private final DiscountPolicy<Ticket> discountPolicy; // ★ Ticket이 자신의 '할인 전략'을 직접 소유

    public Ticket(Customer customer, Showing showing, Theater theater, DiscountPolicy<Ticket> discountPolicy) {
        this.customer = customer;
        this.showing = showing;
        this.theater = theater;
        this.discountPolicy = discountPolicy;
    }

    // Ticket의 가장 핵심적인 책임: "나의 최종 가격을 계산하라"
    public Money calculateFee() {
        // 주입받은 '전략'에게 할인액 계산을 위임한다.
        // Ticket 자신이 할인에 필요한 모든 정보(Context)의 주인이므로, 자기 자신(this)을 넘겨준다.
        Money discountAmount = discountPolicy.calculateDiscountAmount(this);

        // 영화의 원본 가격에서 계산된 할인액을 뺀다.
        return showing.getMovieFee().minus(discountAmount);
    }

    public LocalDateTime getWhenShowing() {
        return showing.getWhenShowing();
    }

    public Money getMovieFee() {
        return showing.getMovieFee();
    }

    public boolean isMatchCustomer(CustomerType condition) {
        return customer.match(condition);
    }

    public boolean isMovieDay() {
        return theater.isMovieDay(getWhenShowing());
    }

    public boolean isDiscountableTime() {
        return theater.isDiscountableTime(getWhenShowing());
    }
}
