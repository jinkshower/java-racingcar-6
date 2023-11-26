package racingcar.domain.car;

import java.util.Objects;

public class Position implements Comparable<Position> {

    private static final int INITIAL_POSITION = 0;
    private int position;

    public Position() {
        this.position = INITIAL_POSITION;
    }

    public void move(int distance) {
        position += distance;
    }

    public String current() {
        return "-".repeat(position);
    }

    @Override
    public int compareTo(Position position) {
        return Integer.compare(this.position, position.position);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Position position1 = (Position) o;
        return position == position1.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }


}

