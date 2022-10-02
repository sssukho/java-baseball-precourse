package baseball.model;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.model.Round.Status;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("기능#4 컴퓨터 측이 생성한 숫자와 사용자 입력 값 비교")
class ScoreServiceTest {
    static ScoreService scoreService;

    @BeforeAll
    static void init() {
        scoreService = new ScoreService();
    }

    @Test
    @DisplayName("1strike")
    void test1() {
        testResult(new TestCase("425", "123", new Score(1, 0)));
    }

    @Test
    @DisplayName("1strike 1ball")
    void test2() {
        testResult(new TestCase("425", "456", new Score(1, 1)));
    }

    @Test
    @DisplayName("nothing")
    void test3() {
        testResult(new TestCase("425", "789", new Score(0, 0)));
    }

    @Test
    @DisplayName("1ball")
    void test4() {
        testResult(new TestCase("713", "145", new Score(0, 1)));
    }

    @Test
    @DisplayName("2ball")
    void test5() {
        testResult(new TestCase("713", "671", new Score(0, 2)));
    }

    @Test
    @DisplayName("3strike")
    void test6() {
        testResult(new TestCase("713", "713", new Score(3, 0)));
    }

    static void testResult(TestCase testCase) {
        assertThat(testCase.answerScore.getBall()).isEqualTo(testCase.resultScore.getBall());
        assertThat(testCase.answerScore.getStrike()).isEqualTo(testCase.resultScore.getStrike());
    }

    static class TestCase {
        public String computerRandomNum;
        public String userInput;
        public Score resultScore;
        public Score answerScore;

        public TestCase(String computerRandomNum, String userInput, Score answerScore) {
            this.computerRandomNum = computerRandomNum;
            this.userInput = userInput;
            Round testRound = generateTestRound(computerRandomNum, userInput);
            this.resultScore = scoreService.processResultScore(testRound);
            this.answerScore = answerScore;
        }

        Round generateTestRound(String computerRandomNum, String userInput) {
            Computer computer = new Computer(ComputerTest.newMap(computerRandomNum));
            User user = new User(userInput);
            Round round = new Round(Status.PLAYING);
            round.setComputer(computer);
            round.setUser(user);
            return round;
        }
    }
}