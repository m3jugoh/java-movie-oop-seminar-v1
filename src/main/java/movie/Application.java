package movie;

import java.util.Arrays;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import movie.domain.Customer;
import movie.domain.Money;
import movie.domain.Movie;
import movie.domain.Showing;
import movie.service.DiscountPolicyFactory;
import movie.service.ReservationService;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // --- 1. 시스템 설정: 전문가와 서비스를 생성하고 연결(주입)합니다. ---
        DiscountPolicyFactory policyFactory = new DiscountPolicyFactory();
        ReservationService reservationService = new ReservationService(policyFactory);

        // --- 2. 데이터 준비: 영화, 상영 정보, 고객 데이터를 생성합니다. ---
        Movie avatar = new Movie("Avatar", Duration.ofMinutes(180), Money.wons(15000));

        // 상영 정보 리스트
        Showing showing1 = new Showing(avatar, LocalDateTime.of(LocalDate.of(2024, 7, 10), LocalTime.of(9, 30))); // 'Movie Day' and 'Time Discount'
        Showing showing2 = new Showing(avatar, LocalDateTime.of(LocalDate.of(2024, 7, 2), LocalTime.of(21, 0))); // Only 'Time Discount'
        Showing showing3 = new Showing(avatar, LocalDateTime.of(LocalDate.of(2024, 8, 20), LocalTime.of(14, 0))); // Only 'Movie Day'
        Showing showing4 = new Showing(avatar, LocalDateTime.of(LocalDate.of(2024, 8, 2), LocalTime.of(15, 0))); // No discount
        List<Showing> showings = Arrays.asList(showing1, showing2, showing3, showing4);

        // 고객 정보 리스트
        Customer disabilityVipCustomer = new Customer(true, true);
        Customer disabilityOnlyCustomer = new Customer(true, false);
        Customer vipOnlyCustomer = new Customer(false, true);
        Customer normalCustomer = new Customer(false, false);
        List<Customer> customers = Arrays.asList(disabilityVipCustomer, disabilityOnlyCustomer, vipOnlyCustomer, normalCustomer);

        // --- 3. 시뮬레이션: 모든 상영과 고객 조합에 대해 예매를 실행하고 결과를 확인합니다. ---
        int scenarioCount = 1;
        for (Showing showing : showings) {
            System.out.println("\n=================================================");
            System.out.printf("===== Showing Condition: %s =====\n", showing.getWhenShowing());
            System.out.println("=================================================");
            for (Customer currentCustomer : customers) {
                String customerType = String.format("Disability:%s, VIP:%s", currentCustomer.isDisability(), currentCustomer.isVip());
                System.out.printf("### Scenario %d: Customer (%s) ###\n", scenarioCount++, customerType);
                Money finalFee = reservationService.reserve(currentCustomer, showing);
                System.out.println("Final Fee: " + finalFee.toLong() + " KRW");
                System.out.println("-------------------------------------------------");
            }
        }
    }
}