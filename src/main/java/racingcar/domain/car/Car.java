package racingcar.domain.car;

import java.util.Comparator;

public class Car {

    public static final Comparator<Car> COMPARATOR_BY_POSITION =
            Comparator.comparing(car -> car.position);
    private final CarName carName;
    private final Position position;
    private final DriveStrategy driveStrategy;

    public Car(CarName carName, Position position, DriveStrategy driveStrategy) {
        this.carName = carName;
        this.position = position;
        this.driveStrategy = driveStrategy;
    }

    public void moveForward() {
        position.move(driveStrategy.determineDistance());
    }

    public String nameAndPosition() {
        return carName.getName() + " : " + position.current();
    }
}
