package movie.domain.policy.condition;

import movie.domain.Tickets;

public class GroupCountCondition implements DiscountCondition<Tickets> {
    @Override
    public boolean isSatisfiedBy(Tickets tickets) {
        return tickets.isGroupCountable();
    }
}
