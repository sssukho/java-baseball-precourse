package baseball.model;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.model.Round.Status;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ScoreServiceTest {
    static ScoreService scoreService;

    @BeforeAll
    static void init() {
        scoreService = new ScoreService();
    }

    @Test
    @DisplayName("기능#4 컴퓨터 측이 생성한 숫자와 사용자 입력 값 비교")
    void test() {
        // com: 425
        Score case1 = getResultScore(generateTestCase("425", "123")); // 1strike
        Score case2 = getResultScore(generateTestCase("425", "456")); // 1ball 1strike
        Score case3 = getResultScore(generateTestCase("425", "789")); // nothing
        // com: 713
        Score case4 = getResultScore(generateTestCase("713", "123")); // 1ball 1strike
        Score case5 = getResultScore(generateTestCase("713", "145")); // 1ball
        Score case6 = getResultScore(generateTestCase("713", "671")); // 2ball
        Score case7 = getResultScore(generateTestCase("713", "216")); // 1strike
        Score case8 = getResultScore(generateTestCase("713", "713")); // 3strike

        testResult(case1, 0, 1); // 1s
        testResult(case2, 1, 1); // 1b 1s
        testResult(case3, 0, 0); // nothing
        testResult(case4, 1, 1); // 1b 1s
        testResult(case5, 1, 0); // 1b
        testResult(case6, 2, 0); // 2b
        testResult(case7, 0, 1); // 1s
        testResult(case8, 0, 3); // 3s
    }

    void testResult(Score scoreResult, int ball, int strike) {
        assertThat(scoreResult.getStrike()).isEqualTo(strike);
        assertThat(scoreResult.getBall()).isEqualTo(ball);
    }

    Score getResultScore(Round round) {
        return scoreService.processResultScore(round);
    }

    Round generateTestCase(String computerRandomNum, String userInput) {
        Computer computer = new Computer(ComputerTest.newMap(computerRandomNum));
        User user = new User(userInput);
        Round round = new Round(Status.PLAYING);
        round.setComputer(computer);
        round.setUser(user);
        return round;
    }
}