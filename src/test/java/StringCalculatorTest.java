import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest {

    StringCalculator calculator;

    @BeforeEach
    public void init() {
        calculator = new StringCalculator();
    }

    @Test
    @DisplayName("")
    void calc() {
        calculator.input();
    }

}