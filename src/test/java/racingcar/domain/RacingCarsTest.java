package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.car.Car;

class RacingCarsTest {

    private static final String DELIMITER = ",";
    @DisplayName("중복되는 이름이 있으면 예외가 발생한다")
    @ParameterizedTest
    @ValueSource(strings = {"pobi, pobi, woni", "lit, pobi, lit"})
    void throwExceptionForDuplication(String text) {
        assertThatThrownBy(() -> RacingCars.of(text.replace(" ", "").split(DELIMITER)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1개의 이름만 있으면 예외가 발생한다")
    @ParameterizedTest
    @ValueSource(strings = {"pobi", "lit"})
    void throwExceptionForSize(String text) {
        assertThatThrownBy(() -> RacingCars.of(text.replace(" ", "").split(DELIMITER)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("정상적으로 입력으로부터 경주용 차들을 생성한다")
    @ParameterizedTest
    @ValueSource(strings = {"pobi, woni, lit", "우아한, 테크, 코스"})
    void properlyCreateRacingCars(String text) {
        assertDoesNotThrow(() -> RacingCars.of(text.replace(" ", "").split(DELIMITER)));
    }

    @Test
    void printResult() {
        RacingCars racingCars = RacingCars.of(new String[] {"pobi", "woni", "lit"});
        racingCars.moveAll();
        racingCars.moveAll();
        racingCars.moveAll();
        racingCars.moveAll();

        List<Car> extracted = racingCars.getRacingCars();
        for (Car car : extracted) {
            System.out.println(car.nameAndPosition());
        }
    }
}
