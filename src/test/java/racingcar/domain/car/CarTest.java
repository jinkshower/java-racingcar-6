package racingcar.domain.car;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {

    @DisplayName("이름이 5자를 초과한 자동차 생성시 예외가 발생한다")
    @ParameterizedTest
    @ValueSource(strings = {"ringri", "우아한테크코"})
    void throwExceptionForName(String name) {
        assertThatThrownBy(() -> new CarBuilder().withCarName(CarName.of(name)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("이름에 특수문자, 공백을 포함, 빈 문자열인 자동차 생성시 예외가 발생한다")
    @ParameterizedTest
    @ValueSource(strings = {"%!l@it", "po bi", ""})
    void throwExceptionForName2(String name) {
        assertThatThrownBy(() -> new CarBuilder().withCarName(CarName.of(name)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("정상적으로 자동차를 생성한다")
    @ParameterizedTest
    @ValueSource(strings = {"pobi", "woni", "lit"})
    void properlyInstantiateCar(String name) {
        assertDoesNotThrow(() -> new CarBuilder()
                .withCarName(CarName.of(name)));
    }

}
