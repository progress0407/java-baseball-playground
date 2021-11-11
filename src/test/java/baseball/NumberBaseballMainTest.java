package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NumberBaseballMainTest {

    BaseBallJudge baseBallJudge = new BaseBallJudge();
    int[] computerNumbers = {4, 2, 5};

    @Test
    @DisplayName("판단 테스트: 1스트라이크 2볼")
    void judgeTest() {
        // given
        int[] userNumbers = {2, 4, 5};

        // when
        List<String> results = baseBallJudge.judgeNumbers(userNumbers, computerNumbers);

        // then
        Assertions.assertThat(results).containsExactly("1스트라이크", "2볼");
    }

    @Test
    @DisplayName("판단 테스트: 2볼")
    void judgeTest2() {
        // given
        int[] userNumbers = {5, 1, 2};

        // when
        List<String> results = baseBallJudge.judgeNumbers(userNumbers, computerNumbers);

        // then
        Assertions.assertThat(results).containsExactly("2볼");
    }

    @Test
    @DisplayName("판단 테스트: 1스트라이크")
    void judgeTest3() {
        // given
        int[] userNumbers = {3, 1, 5};

        // when
        List<String> results = baseBallJudge.judgeNumbers(userNumbers, computerNumbers);

        // then
        Assertions.assertThat(results).containsExactly("1스트라이크");
    }

    @Test
    @DisplayName("판단 테스트: 낫싱")
    void judgeTest4() {
        // given
        int[] userNumbers = {1, 3, 6};

        // when
        List<String> results = baseBallJudge.judgeNumbers(userNumbers, computerNumbers);

        // then
        Assertions.assertThat(results).containsExactly("낫싱");
    }

    @Test
    @DisplayName("판단 테스트: 연속된 테스트")
    // 가장 마지막의 상태만이 기록되어야 한다
    void judgeTest5() {
        // given & when
        int[] userNumbers = {5, 1, 2}; // 2볼

        baseBallJudge.judgeNumbers(userNumbers, computerNumbers);

        userNumbers = new int[]{3, 1, 5}; // 1스트라이크

        List<String> results = baseBallJudge.judgeNumbers(userNumbers, computerNumbers);

        // then
        Assertions.assertThat(results).containsExactly("1스트라이크");
    }

}