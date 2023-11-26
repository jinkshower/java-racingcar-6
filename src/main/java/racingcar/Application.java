package racingcar;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.RacingCars;
import racingcar.domain.Winners;
import racingcar.domain.car.Car;
import racingcar.domain.car.CarBuilder;
import racingcar.domain.car.CarName;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = InputView.getInstance();
        OutputView outputView = OutputView.getInstance();

        String userInputCarNames = inputView.readCarNames();
        int attemptCount = inputView.readAttemptCount();

        RacingCars racingCars = createRacingCars(userInputCarNames
                .replace(" ","")
                .split(","));

        while(attemptCount-- > 0) {
            racingCars.moveAll();
            outputView.printDriveResult(racingCars.getRacingCars()
                    .stream()
                    .map(Car::nameAndPosition)
                    .toList());
        }

        Winners winners = Winners.of(racingCars.getRacingCars());
        outputView.printWinners(winners.getWinners().stream()
                .map(Car::getCarName)
                .toList());
    }
    private static RacingCars createRacingCars(String[] splitCarNames) {
        List<Car> generatedCars = new ArrayList<>();
        for (String input : splitCarNames) {
            generatedCars.add(new CarBuilder()
                    .withCarName(CarName.of(input))
                    .build());
        }
        return new RacingCars(generatedCars);
    }
}
