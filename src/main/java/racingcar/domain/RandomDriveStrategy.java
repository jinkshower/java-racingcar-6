package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.function.IntSupplier;

public class RandomDriveStrategy implements DriveStrategy {

    private final IntSupplier numberGenerator;

    public RandomDriveStrategy(IntSupplier numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    @Override
    public int determineDistance() {
        int generatedNumber = numberGenerator.getAsInt();
        validateRange(generatedNumber);

        if (generatedNumber >= 4) {
            return 1;
        }
        return 0;
    }

    private void validateRange(int generatedNumber) {
        if (generatedNumber < 1 || generatedNumber > 9) {
            throw new IllegalArgumentException();
        }
    }

    public static int generateRandomNumber() {
        return Randoms.pickNumberInRange(1, 9);
    }
}
