package baseball.utils;

import baseball.model.Score;

public class MessageGenerator {
    private static final String NOTHING_MESSAGE = "낫싱\n";
    private static final String THREE_STRIKE_MESSAGE = "3스트라이크\n";
    private static final String GAME_END_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료\n";

    public static String generateScoreMessage(Score resultScore) {
        if (resultScore.getBall() == 0 && resultScore.getStrike() == 0) {
            return NOTHING_MESSAGE;
        }
        if (resultScore.getStrike() == 3) {
            return THREE_STRIKE_MESSAGE + GAME_END_MESSAGE;
        }
        return getComplicatedScoreMessage(resultScore.getStrike(), resultScore.getBall());
    }

    private static String getComplicatedScoreMessage(int strike, int ball) {
        if (strike > 0 && ball > 0) {
            return ball + "볼 " + strike + "스트라이크\n";
        }
        else if (strike > 0 && ball == 0) {
            return strike + "스트라이크\n";
        }
        return ball + "볼\n";
    }
}
