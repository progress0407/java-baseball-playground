package baseball;

import java.util.ArrayList;
import java.util.List;

public class Balls {

    private List<Ball> answers;

    public Balls(List<Integer> answers) {
        this.answers = mapBall(answers);
    }
    
    // 인스턴스 변수에 의존하지 않으므로 클래스 메서드로 가능
    private static List<Ball> mapBall(List<Integer> answers) {
        List<Ball> balls = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            balls.add(new Ball(i + 1, answers.get(i)));
        }
        return balls;
    }

    public PlayResult play(List<Integer> userBallsArg) {
        Balls userBalls = new Balls(userBallsArg);
        PlayResult result = new PlayResult();
        List<BallStatus> ballStatuses = new ArrayList<>();
        for (Ball answer : answers) {
            ballStatuses.add(userBalls.play(answer));
        }
        int strikeCount = (int) ballStatuses.stream()
                .filter(e -> e == BallStatus.STRIKE)
                .count();

        int ballCount = (int) ballStatuses.stream()
                .filter(e -> e == BallStatus.BALL)
                .count();

        result.setStrikeCount(strikeCount);
        result.setBallCount(ballCount);

        return result;
    }

    public BallStatus play(Ball userBall) {
        return answers.stream()
                .map(answer -> answer.play(userBall))
                .filter(BallStatus::isNotNothing)
                .findFirst()
                .orElse(BallStatus.NOTHING);
    }
}
