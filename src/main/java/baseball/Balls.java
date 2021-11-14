package baseball;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Balls {

    List<Ball> balls;

    public Balls(List<Ball> balls) {
        this.balls = balls;
//        this.balls = Collections.unmodifiableList(balls);
    }

    public List<Ball> getBalls() {
        return balls;
    }

    public BallStatus play(Ball com) {

        List<BallStatus> statuses = new ArrayList<>();
        for (Ball ball : balls) {
            BallStatus status = ball.play(com);
            statuses.add(status);
        }

        BallStatus status = statuses.stream().filter(e -> e.equals(BallStatus.STRIKE)).findAny().orElseGet(()->BallStatus.NOTHING);

        if (status != BallStatus.NOTHING) {
            return BallStatus.STRIKE;
        }

        status = statuses.stream().filter(e -> e.equals(BallStatus.BALL)).findAny().orElseGet(()->BallStatus.NOTHING);
        if (status != BallStatus.NOTHING) {
            return BallStatus.BALL;
        }

        return BallStatus.NOTHING;
    }

    public BallStatus plays(Balls coms) {
        List<BallStatus> statuses = new ArrayList<>();
        for (Ball ball : balls) {
            BallStatus status = coms.play(ball);
            statuses.add(status);
        }

        BallStatus status = statuses.stream().filter(e -> e.equals(BallStatus.STRIKE)).findAny().orElseGet(()->BallStatus.NOTHING);
        if (status != BallStatus.NOTHING) {
            return BallStatus.STRIKE;
        }
        status = statuses.stream().filter(e -> e.equals(BallStatus.BALL)).findAny().orElseGet(()->BallStatus.NOTHING);
        if (status != BallStatus.NOTHING) {
            return BallStatus.BALL;
        }

        return BallStatus.NOTHING;
    }
}
