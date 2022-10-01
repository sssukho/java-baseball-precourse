package baseball.model;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class UserTest {
    @DisplayName("기능#2 사용자 입력 값 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"1234", "5", "asd", "777", "404"})
    void testUserInput(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new User(input));
    }
}