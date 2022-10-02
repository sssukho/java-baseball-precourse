package baseball.model;

import java.util.Map;

public class ScoreService {
    private static final int NONE = 0;
    private static final int STRIKE = 1;
    private static final int BALL = 2;

    public Score processResultScore(Game game) {
        Score resultScore = new Score(0, 0);
        int position = 0;
        for (char userNum : game.getUser().getRandomNumCharArr()) {
            int compareResult = compareUserWithComputer(game.getComputer().getRandomNumbers(), userNum - '0', position);
            countResultScore(resultScore, compareResult);
            position++;
        }
        return resultScore;
    }

    private void countResultScore(Score resultScore, int compareResult) {
        if (compareResult == STRIKE) {
            resultScore.setStrike(resultScore.getStrike() + 1);
        } else if (compareResult == BALL) {
            resultScore.setBall(resultScore.getBall() + 1);
        }
    }

    private int compareUserWithComputer(Map<Integer, Integer> computerRandomNumbers, int userNum, int position) {
        if (computerRandomNumbers.containsKey(userNum)) {
            return compareWhetherStrikeOrBall(computerRandomNumbers, userNum, position);
        }
        return NONE;
    }

    private int compareWhetherStrikeOrBall(Map<Integer, Integer> computerRandomNumbers, int userNum, int position) {
        if (computerRandomNumbers.get(userNum) == position) {
            return STRIKE;
        }
        return BALL;
    }
}
