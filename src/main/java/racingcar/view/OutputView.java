package racingcar.view;

import java.util.List;

public class OutputView {

    private static final OutputView instance = new OutputView();

    public static OutputView getInstance() {
        return instance;
    }

    private OutputView() {
    }

    public void printDriveResult(List<String> result) {
        for (String string: result) {
            System.out.println(string);
        }
        System.out.println();
    }

    public void printWinners(List<String> winners) {
        System.out.printf("최종 우승자 : %s%n", winners.toString().replaceAll("[\\[\\]]",""));
    }
}
