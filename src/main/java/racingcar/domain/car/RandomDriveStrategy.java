package racingcar.domain.car;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.function.IntSupplier;

public class RandomDriveStrategy implements DriveStrategy {

    private static final int MOVE_FORWARD_THRESHOLD = 4;
    private static final int MOVE_FORWARD_DISTANCE = 1;
    private static final int NO_MOVEMENT_AMOUNT = 0;
    private static final int MIN_RANDOM_NUMBER = 1;
    private static final int MAX_RANDOM_NUMBER = 9;

    private final IntSupplier numberGenerator;

    public RandomDriveStrategy(IntSupplier numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    @Override
    public int determineDistance() {
        int generatedNumber = numberGenerator.getAsInt();
        validateRange(generatedNumber);

        if (generatedNumber >= MOVE_FORWARD_THRESHOLD) {
            return MOVE_FORWARD_DISTANCE;
        }
        return NO_MOVEMENT_AMOUNT;
    }

    private void validateRange(int generatedNumber) {
        if (generatedNumber < MIN_RANDOM_NUMBER || generatedNumber > MAX_RANDOM_NUMBER) {
            throw new IllegalArgumentException();
        }
    }

    public static int generateRandomNumber() {
        return Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
    }
}
