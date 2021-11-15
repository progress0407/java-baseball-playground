package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BallsTest {

    /**
     * 123 1 1 strike
     * 123 2 1 ball
     * 123 1 4 nothing
     */

    @Test
    void play_nothing() {
        Balls answers = new Balls(Arrays.asList(1, 2, 3));
        PlayResult result = answers.play(Arrays.asList(4, 5, 6));
        assertThat(result.getStrike()).isEqualTo(0);
        assertThat(result.getBall()).isEqualTo(0);
    }

    @Test
    void play_1strike_1ball() {
        Balls answers = new Balls(Arrays.asList(1, 2, 3));
        PlayResult result = answers.play(Arrays.asList(1, 4, 2));
        assertThat(result.getStrike()).isEqualTo(1);
        assertThat(result.getBall()).isEqualTo(1);
    }

    @Test
    void strike() {
        Balls answers = new Balls(Arrays.asList(1, 2, 3));
        BallStatus status = answers.play(new Ball(1, 1));
        assertThat(status).isEqualTo(BallStatus.STRIKE);
    }

    @Test
    void ball() {
        Balls answers = new Balls(Arrays.asList(1, 2, 3));
        BallStatus status = answers.play(new Ball(1, 2));
        assertThat(status).isEqualTo(BallStatus.BALL);
    }

    @Test
    void nothing() {
        Balls answers = new Balls(Arrays.asList(1, 2, 3));
        BallStatus status = answers.play(new Ball(1, 4));
        assertThat(status).isEqualTo(BallStatus.NOTHING);
    }
}
