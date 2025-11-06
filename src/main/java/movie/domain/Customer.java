package movie.domain;

public class Customer {
    private final boolean isDisability;
    private final boolean isVip;

    public Customer(boolean isDisability, boolean isVip) {
        this.isDisability = isDisability;
        this.isVip = isVip;
    }

    public boolean isDisability() {
        return isDisability;
    }

    public boolean isVip() {
        return isVip;
    }
}
