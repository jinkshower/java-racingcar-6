package racingcar.domain.car;

public class CarBuilder {

    private CarName carName;
    private Position position = new Position();
    private DriveStrategy driveStrategy = new RandomDriveStrategy(RandomDriveStrategy::generateRandomNumber);

    public CarBuilder withCarName(CarName carName) {
        this.carName = carName;
        return this;
    }

    public CarBuilder withPosition(Position position) {
        this.position = position;
        return this;
    }

    public CarBuilder withDriveStrategy(DriveStrategy driveStrategy) {
        this.driveStrategy = driveStrategy;
        return this;
    }

    public Car build() {
        return new Car(carName, position, driveStrategy);
    }
}
