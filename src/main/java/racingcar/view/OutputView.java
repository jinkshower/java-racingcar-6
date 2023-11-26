package racingcar.view;

import java.util.List;
import racingcar.domain.RacingCars;
import racingcar.domain.Winners;
import racingcar.domain.car.Car;

public class OutputView {

    private static final OutputView instance = new OutputView();

    public static OutputView getInstance() {
        return instance;
    }

    private OutputView() {
    }

    public void printDriveResult(RacingCars racingCars) {
        List<String> result = racingCars.getRacingCars()
                .stream()
                .map(Car::nameAndPosition)
                .toList();
        for (String string : result) {
            System.out.println(string);
        }
        System.out.println();
    }

    public void printWinners(Winners winners) {
        List<String> winnersWithCarNames = winners.getWinners().stream()
                .map(Car::getCarName)
                .toList();
        String result = String.join(", ", winnersWithCarNames);
        System.out.printf("최종 우승자 : %s%n", result);
    }
}
