package racingcar.domain.car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.car.DriveStrategy;
import racingcar.domain.car.RandomDriveStrategy;

class RandomDriveStrategyTest {

    @DisplayName("숫자가 4이상 일 때 전진 거리는 1이다")
    @ParameterizedTest
    @CsvSource(value = {"4,1", "8,1"})
    void determineDistance1(int value, int expected) {
        DriveStrategy randomDriveStrategy = new RandomDriveStrategy(() ->value);

        int actual= randomDriveStrategy.determineDistance();

        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("숫자가 4미만 일 때 전진 거리는 0이다")
    @ParameterizedTest
    @CsvSource(value = {"1,0", "3,0"})
    void determineDistance2(int value, int expected) {
        DriveStrategy randomDriveStrategy = new RandomDriveStrategy(() ->value);

        int actual= randomDriveStrategy.determineDistance();

        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("생성된 숫자가 1~9사이가 아니면 예외가 발생 한다")
    @ParameterizedTest
    @ValueSource(ints = {0, 10, -1})
    void thorwException(int value) {
        DriveStrategy driveStrategy = new RandomDriveStrategy(() -> value);

        assertThatThrownBy(driveStrategy::determineDistance)
                .isInstanceOf(IllegalArgumentException.class);
    }

}
