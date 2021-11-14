package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BallsTest {

    /**
     * 123 1 1 strike
     * 123 2 1 ball
     * 123 1 4 nothing
     */

    Balls coms;

    @BeforeEach
    void setUp() {
        List<Ball> balls = new ArrayList<>();
        balls.add(new Ball(1, 1));
        balls.add(new Ball(2, 2));
        balls.add(new Ball(3, 3));
        coms = new Balls(balls);
    }

    @Test
    void strike() {
        Ball com = new Ball(1, 1);
        BallStatus status = coms.play(com);
        assertThat(status).isEqualTo(BallStatus.STRIKE);
    }

    @Test
    void ball() {
        Ball com = new Ball(2, 1);
        BallStatus status = coms.play(com);
        assertThat(status).isEqualTo(BallStatus.BALL);
    }

    @Test
    void nothing() {
        Ball com = new Ball(1, 4);
        BallStatus status = coms.play(com);
        assertThat(status).isEqualTo(BallStatus.NOTHING);
    }


    @Test
    void strike2() {
        List<Ball> balls2 = new ArrayList<>();
        balls2.add(new Ball(1, 1));
        balls2.add(new Ball(2, 2));
        balls2.add(new Ball(3, 3));


        Balls coms2 = new Balls(balls2);
//        coms2.getBalls().add(new Ball(3, 3));

        BallStatus status = coms.plays(coms2);
        assertThat(status).isEqualTo(BallStatus.STRIKE);
    }
}
