package movie.domain.matchingbox;

import java.util.Set;

import movie.domain.CustomerType;

public class CustomerBox implements MatchingBox<CustomerType> {
    private final Set<CustomerType> customerTypes;

    public CustomerBox(Set<CustomerType> customerTypes) {
        if (customerTypes == null) {
            throw new IllegalArgumentException("Conditions cannot be null");
        }
        this.customerTypes = customerTypes;
    }

    @Override
    public boolean match(CustomerType unit) {
        return customerTypes.contains(unit);
    }
}
