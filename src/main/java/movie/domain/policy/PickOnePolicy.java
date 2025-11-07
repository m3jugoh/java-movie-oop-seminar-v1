package movie.domain.policy;

import java.util.Comparator;
import java.util.List;

import movie.domain.Money;

/**
 * 여러 정책 중 가장 할인 금액이 큰 정책 하나만 선택하여 적용하는 정책.
 * "중복 불가" 규칙을 구현할 때 사용한다.
 */
public class PickOnePolicy<T> implements DiscountPolicy<T> {
    private final List<DiscountPolicy<T>> policies;

    public PickOnePolicy(DiscountPolicy<T>... policies) {
        this.policies = List.of(policies);
    }

    @Override
    public Money calculateDiscountAmount(T t) {
        return policies.stream()
                .map(policy -> policy.calculateDiscountAmount(t)) // 각 정책의 할인액을 계산
                .max(Comparator.comparing(Money::toLong)) // 가장 큰 할인액을 찾음
                .orElse(Money.ZERO); // 할인액이 없으면 0원 반환
    }
}
