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
        RacingCars racingCars = createRacingCars(userInputCarNames);
        int attemptCount = inputView.readAttemptCount();

        while(attemptCount-- > 0) {
            racingCars.moveAll();
            outputView.printDriveResult(racingCars);
        }

        Winners winners = Winners.of(racingCars.getRacingCars());
        outputView.printWinners(winners);
    }
    private static RacingCars createRacingCars(String userInputCarNames) {
        List<Car> generatedCars = new ArrayList<>();
        String[] splitCarNames = userInputCarNames
                .replace(" ","")
                .split(",");
        for (String input : splitCarNames) {
            generatedCars.add(new CarBuilder()
                    .withCarName(CarName.of(input))
                    .build());
        }
        return new RacingCars(generatedCars);
    }
}
