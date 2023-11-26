package racingcar.domain.car;

import java.util.Comparator;

public class Car {

    public static final Comparator<Car> COMPARATOR_BY_POSITION =
            Comparator.comparing(car -> car.position);
    private static final String NAME_DISTANCE_DELIMITER = " : ";

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
        return carName.getName() + NAME_DISTANCE_DELIMITER + position.current();
    }

    public boolean hasSamePosition(Car car) {
        return this.position.equals(car.position);
    }

    public String getCarName() {
        return carName.getName();
    }
}
