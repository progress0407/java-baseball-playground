package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ValidationUtilsTest {

    /**
     * 경곗값을 중심으로 검증 코드를 짠다
     */

    @Test
    @DisplayName("야구 숫자 1 ~ 9 검증")
    void 야구_숫자_1_9_검증() {
        assertThat(ValidationUtils.valid(0)).isFalse();
        assertThat(ValidationUtils.valid(1)).isTrue();
        assertThat(ValidationUtils.valid(9)).isTrue();
        assertThat(ValidationUtils.valid(10)).isFalse();
    }


}
