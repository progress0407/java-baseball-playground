package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    @DisplayName("요구사항 1")
    void 요구사항1() {
        // given
        // when
        String[] actual = "1,2".split(",");
        // then
//        assertThat(actual).containsExactly("1", "2");
        assertThat(actual).contains("1", "2");
    }

    @Test
    @DisplayName("요구사항 2")
    void 요구사항2() {
        // given
        String actual = "(1,2)";
        // when
        String substring = actual.substring(1, 4);
        // then
        assertThat(substring).isEqualTo("1,2");
    }

    @Test
    @DisplayName("요구사항 3")
    void 요구사항3() {
        // given
        String actual = "abc";
        // when
        int index = 3;
        // then
//        assertThat(c).isEqualTo('c');
        assertThatThrownBy(() -> {
            char c = actual.charAt(index);
        })
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("%d", index);
    }

    @Test
    @DisplayName("요구사항3 복습")
    void 요구사항3_review() {

        String actual = "abc";

        int index = 3;

        assertThatThrownBy(() -> {
            char c = actual.charAt(index);
        })
//                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("%d", index);
    }


    @Test
    @DisplayName("요구사항3_2")
    void 요구사항3_2() {

        String actual = "abc";

        int index = 3;

        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    char c = actual.charAt(index);
                })
                .withMessageMatching("String index out of range: 3");

    }

    @Test
    @DisplayName("아주 간단한 예제")
    void a_few_simple_assertions() {

        assertThat("The Lord of the Rings")
                .isNotNull()
                .startsWith("The")
                .contains("Lord")
                .endsWith("Rings");

    }
}