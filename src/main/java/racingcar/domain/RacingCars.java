package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import racingcar.domain.car.Car;

public class RacingCars {

    private static final int MIN_CAR_COUNT = 2;
    private final List<Car> racingCars;

    public RacingCars(List<Car> generatedCars) {
        validate(generatedCars);
        this.racingCars = new ArrayList<>(generatedCars);
    }

    private static void validate(List<Car> generatedCars) {
        if (hasDuplication(generatedCars)) {
            throw new IllegalArgumentException("중복 ㄴㄴ");
        }
        if (generatedCars.size() < MIN_CAR_COUNT) {
            throw new IllegalArgumentException("2대이상만");
        }
    }

    private static boolean hasDuplication(List<Car> generatedCars) {
        return Set.copyOf(generatedCars).size() != generatedCars.size();
    }

    public void moveAll() {
        racingCars.forEach(Car::moveForward);
    }

    public List<Car> getRacingCars() {
        return new ArrayList<>(racingCars);
    }

    //    public static RacingCars of(String[] splitInput) {
//        validate(splitInput);
//
//        List<Car> generatedCars = new ArrayList<>();
//        for (String input : splitInput) {
//            generatedCars.add(new CarBuilder()
//                    .withCarName(CarName.of(input))
//                    .build());
//        }
//        return new RacingCars(generatedCars);
//    }
}
