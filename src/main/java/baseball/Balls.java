package baseball;

import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;

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

    public PlayResult play(List<Integer> balls) {
        Balls userBalls = new Balls(balls);
        PlayResult result = new PlayResult();
        for (Ball answer : answers) {
            BallStatus status = userBalls.play(answer);
            result.report(status);
        }
        return result;
    }

    public BallStatus play(Ball userBall) {
        out.println("Balls.play");
        return answers.stream()
                .map(answer -> answer.play(userBall))
                .filter(BallStatus::isNotNothing)
                .peek(out::println)
                .findFirst()
                .orElse(BallStatus.NOTHING);
    }
}
