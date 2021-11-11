import calculator.StringCalculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StringCalculatorTest {

    StringCalculator calculator;

    @BeforeEach
    public void init() {
        calculator = new StringCalculator();
    }

    @Test
    @DisplayName("문자열 계산기 테스트")
    void calc() {
        calculator.inputAuto("3 + 4 + 3");
        double result = calculator.calc();
        assertThat(result).isEqualTo(10.0);
    }

}