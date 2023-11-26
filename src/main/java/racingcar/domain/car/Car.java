package racingcar.domain.car;

public class Car {

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
}
