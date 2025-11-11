package movie.domain;

import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;

import movie.domain.matchingbox.CustomerBox;
import movie.domain.matchingbox.MatchingBox;

public class Customer {
    private final MatchingBox<CustomerType> customerBox;

    // 기본 생성자는 private으로 변경하여 외부에서 직접적인 생성을 막는다.
    private Customer(MatchingBox<CustomerType> customerBox) {
        this.customerBox = customerBox;
    }

    /**
     * 지정된 조건들을 만족하는 '특별 고객'을 생성합니다.
     * @param types 고객이 만족하는 할인 조건들의 집합 (e.g., CustomerConditionType.VIP)
     */
    public static Customer with(CustomerType... types) {
        // EnumSet 생성 로직을 캡슐화한다.
        Set<CustomerType> conditionSet = EnumSet.noneOf(CustomerType.class);
        Collections.addAll(conditionSet, types);
        return new Customer(new CustomerBox(conditionSet));
    }


    public boolean match(CustomerType type) {
        return this.customerBox.match(type);
    }
}
