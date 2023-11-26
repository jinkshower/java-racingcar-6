package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.Car;
import racingcar.domain.car.CarBuilder;
import racingcar.domain.car.CarName;

class WinnersTest {

    @DisplayName("우승자를 정할 수 있다")
    @Test
    void findWinner() {
        RacingCars racingCars = new RacingCars(createCars());
        racingCars.moveAll();

        Winners winners = Winners.of(racingCars.getRacingCars());
        List<String> winnerNames = winners.getWinners().stream()
                .map(Car::getCarName)
                .toList();

        assertThat(winnerNames).isEqualTo(List.of("car1", "car4", "car5"));
    }

    private static List<Car> createCars() {
        return List.of(
                new CarBuilder().withCarName(CarName.of("car1")).withDriveStrategy(() -> 5).build(),
                new CarBuilder().withCarName(CarName.of("car2")).withDriveStrategy(() -> 4).build(),
                new CarBuilder().withCarName(CarName.of("car3")).withDriveStrategy(() -> 3).build(),
                new CarBuilder().withCarName(CarName.of("car4")).withDriveStrategy(() -> 5).build(),
                new CarBuilder().withCarName(CarName.of("car5")).withDriveStrategy(() -> 5).build()
        );
    }
}
