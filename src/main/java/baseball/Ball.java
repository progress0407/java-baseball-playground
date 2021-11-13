package baseball;

import java.util.Objects;

public class Ball {
    private int position;
    private int ballNo;

    public Ball(int a, int ballNo) {
        this.position = a;
        this.ballNo = ballNo;
    }

    public BallStatus play(Ball ball) {
        // NPE 문제로 ball이 뒤에 있는 게 안전
        if (this.equals(ball)) {
            return BallStatus.STRIKE;
        }
        if (matchBallNo(ball)) {
            return BallStatus.BALL;
        }
        return BallStatus.NOTHING;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ball)) return false;
        Ball ball = (Ball) o;
        return position == ball.position && ballNo == ball.ballNo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, ballNo);
    }

    private boolean matchBallNo(Ball ball) {
        return ballNo == ball.ballNo;
    }
}
