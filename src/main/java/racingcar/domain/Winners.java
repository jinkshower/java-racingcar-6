package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.car.Car;

public class Winners {

    private final List<Car> winners;

    private Winners(List<Car> winners) {
        this.winners = new ArrayList<>(winners);
    }

    public static Winners of(List<Car> racingCars) {
        return new Winners(findWinners(racingCars));
    }

    private static List<Car> findWinners(List<Car> racingCars) {
        Car winner = findWinner(racingCars);

        return racingCars.stream()
                .filter(car -> car.hasSamePosition(winner))
                .toList();
    }

    private static Car findWinner(List<Car> racingCars) {
        return racingCars.stream()
                .max(Car.COMPARATOR_BY_POSITION)
                .orElseThrow(IllegalArgumentException::new);
    }

    public List<Car> getWinners() {
        return new ArrayList<>(winners);
    }
}
