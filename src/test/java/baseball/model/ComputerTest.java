package baseball.model;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class ComputerTest {
    @DisplayName("기능#1 컴퓨터 랜덤 생성 테스트")
    @ParameterizedTest
    @MethodSource("randomNumberMapListProvider")
    void testComputerRandomNumberMap(Map<Integer, Integer> randomMap) {
        assertThatIllegalArgumentException().isThrownBy(() -> new Computer(randomMap));
    }

    static List<Map<Integer, Integer>> randomNumberMapListProvider() {
        return new ArrayList<>(Arrays.asList(newMap("112"), newMap("1234"), newMap("asd"), newMap("5"), newMap("404")));
    }

    static Map<Integer, Integer> newMap(String input) {
        Map<Integer, Integer> map = new HashMap<>();
        int i = 0;
        for (char c : input.toCharArray()) {
            map.put(c - '0', i);
            i++;
        }
        return map;
    }
}