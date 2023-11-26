package racingcar.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import racingcar.domain.car.Car;
import racingcar.domain.car.CarBuilder;
import racingcar.domain.car.CarName;

public class RacingCars {

    private static final int MIN_CAR_COUNT = 2;
    private final List<Car> racingCars;

    private RacingCars(List<Car> racingCars) {
        this.racingCars = new ArrayList<>(racingCars);
    }

    public static RacingCars of(String[] splitInput) {
        validate(splitInput);

        List<Car> generatedCars = new ArrayList<>();
        for (String input : splitInput) {
            generatedCars.add(new CarBuilder()
                    .withCarName(CarName.of(input))
                    .build());
        }
        return new RacingCars(generatedCars);
    }

    private static void validate(String[] userInput) {
        if (hasDuplication(userInput)) {
            throw new IllegalArgumentException("중복 ㄴㄴ. text:%s");
        }
        if (userInput.length < MIN_CAR_COUNT) {
            throw new IllegalArgumentException("2대이상만. text:%s");
        }
    }

    private static boolean hasDuplication(String[] text) {
        return Arrays.stream(text).distinct().count() != text.length;
    }

    public void moveAll() {
        racingCars.forEach(Car::moveForward);
    }
}
