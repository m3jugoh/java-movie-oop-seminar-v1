package movie.domain;

import java.util.List;

import movie.domain.policy.DiscountPolicy;

public class Tickets {
    private final List<Ticket> tickets;
    private final DiscountPolicy<Tickets> discountPolicy;

    public Tickets(List<Ticket> tickets, DiscountPolicy<Tickets> discountPolicy) {
        // 방어 로직: 비어있는 티켓 리스트나, 다른 고객의 티켓이 섞여있는지 확인할 수 있다.
        if (tickets == null || tickets.isEmpty()) {
            throw new IllegalArgumentException("티켓 목록은 비어있을 수 없습니다.");
        }
        this.tickets = tickets;
        this.discountPolicy = discountPolicy;
    }

    // 총 결제액 계산
    public Money calculateTotalFee() {
        return totalFee().minus(discountPolicy.calculateDiscountAmount(this));
    }

    public Money totalFee() {
        return tickets.stream()
                .map(Ticket::calculateFee)
                .reduce(Money.ZERO, Money::plus);
    }

    public int ticketCount() {
        return tickets.size();
    }
}
