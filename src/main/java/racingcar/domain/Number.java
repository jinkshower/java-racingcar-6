package racingcar.domain;

import static racingcar.util.Validator.*;
import static racingcar.view.InputView.askHowManyRounds;
import static racingcar.util.Utils.convertStringToInt;

import camp.nextstep.edu.missionutils.Randoms;

public class Number {
    private int number;

    private Number(int randomNumber) {
        this.number = randomNumber;
    }
    public static Number generateRandomNumber() {
        int randomNumber = Randoms.pickNumberInRange(0,9);
        return new Number(randomNumber);
    }

    private Number(String userInput) {
        validateEmpty(userInput);
        validateInteger(userInput);
        validatePositive(userInput);

        this.number = convertStringToInt(userInput);
    }
    public static Number inputUserRounds() {
        String userInput = askHowManyRounds();
        return new Number(userInput);
    }

    public int getNumber() {
        return number;
    }

    public boolean isEqualOrGreaterThanFour() {
        return this.number >= 4;
    }

}
