package racingcar.domain.car;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CarName {

    private static final int MAX_NAME_SIZE = 5;
    private static final Pattern CAR_NAME_PATTERN = Pattern.compile("^[0-9a-zA-Zㄱ-ㅎ가-힣]*$");
    private final String name;

    private CarName(String name) {
        this.name = name;
    }

    public static CarName of(String name) {
        validate(name);
        return new CarName(name);
    }

    private static void validate(String text) {
        if (text.length() > MAX_NAME_SIZE) {
            throw new IllegalArgumentException(String.format("5자 이하의 이름만 가능합니다. text:%s", text));
        }
        Matcher matcher = CAR_NAME_PATTERN.matcher(text);
        if (!matcher.matches()) {
            throw new IllegalArgumentException(String.format("이상한 이름 안-돼. text:%s", text));
        }
        if (text.isEmpty()) {
            throw new IllegalArgumentException(String.format("빈 문자열 안-돼. text:%s", text));
        }
    }

    public String getName() {
        return name;
    }
}
