package baseball;

import java.util.Objects;

public class BallNumber {

    public static final int MIN_NO = 1;
    public static final int MAX_NO = 9;
    private int no;

    public BallNumber(int no) {
        if (no < MIN_NO || no > MAX_NO) {
            throw new IllegalStateException("공의 숫자는 1 ~ 9 까지 입니다.");
        }
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BallNumber)) return false;
        BallNumber that = (BallNumber) o;
        return getNo() == that.getNo();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNo());
    }
}
