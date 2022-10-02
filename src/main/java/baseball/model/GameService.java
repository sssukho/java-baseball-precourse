package baseball.model;

import baseball.model.Round.Status;
import baseball.utils.NumberGenerator;

public class GameService {
    private static final int GENERATE_RANDOM_NUM_SIZE = 3;
    private static final int GENERATE_RANDOM_NUM_RANGE_START = 1;
    private static final int GENERATE_RANDOM_NUM_RANGE_END = 9;

    private static final int STRIKE_OUT = 3;

    private final ScoreService scoreService;

    public GameService(ScoreService scoreService) {
        this.scoreService = scoreService;
    }

    public Score match(Round round) {
        generateComputerRandomNumbersIfAbsent(round);
        Score resultScore = scoreService.processResultScore(round);
        setGameStatus(round, resultScore);
        return resultScore;
    }

    private void generateComputerRandomNumbersIfAbsent(Round round) {
        if (round.getStatus() == Status.INIT) {
            round.setComputer(new Computer(
                    NumberGenerator.generateRandomNumberMap(GENERATE_RANDOM_NUM_SIZE, GENERATE_RANDOM_NUM_RANGE_START,
                            GENERATE_RANDOM_NUM_RANGE_END)));
        }
    }

    private void setGameStatus(Round round, Score resultScore) {
        if (resultScore.getStrike() == STRIKE_OUT) {
            round.setStatus(Status.END);
            return;
        }
        round.setStatus(Status.PLAYING);
    }
}
