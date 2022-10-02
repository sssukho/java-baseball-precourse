package baseball.model;

import baseball.model.Game.Status;
import baseball.utils.MessageGenerator;
import baseball.utils.NumberGenerator;
import baseball.view.View;

public class GameService {
    private static final int GENERATE_RANDOM_NUM_SIZE = 3;
    private static final int GENERATE_RANDOM_NUM_RANGE_START = 1;
    private static final int GENERATE_RANDOM_NUM_RANGE_END = 9;

    private static final String NEW_GAME = "1";
    private static final String EXIT = "2";

    private final View view;
    private final ScoreService scoreService;

    public GameService(View view, ScoreService scoreService) {
        this.view = view;
        this.scoreService = scoreService;
    }

    public void match(Game game) {
        generateComputerRandomNumbersIfAbsent(game);
        Score resultScore = scoreService.processResultScore(game);
        setGameStatus(game, resultScore);
        view.printScore(MessageGenerator.generateScoreMessage(resultScore));
    }

    private void generateComputerRandomNumbersIfAbsent(Game game) {
        if (game.getStatus() == Status.INIT) {
            game.setComputer(new Computer(
                    NumberGenerator.generateRandomNumberMap(GENERATE_RANDOM_NUM_SIZE, GENERATE_RANDOM_NUM_RANGE_START,
                            GENERATE_RANDOM_NUM_RANGE_END)));
        }
    }

    private void setGameStatus(Game game, Score resultScore) {
        if (resultScore.getStrike() == 3) {
            game.setStatus(Status.END);
            return;
        }
        game.setStatus(Status.PLAYING);
    }

    public void decideRestart(String userInput, BaseballGame baseballGame) {
        if (userInput.contentEquals(NEW_GAME)) {
            restart(baseballGame);
            return;
        } else if (userInput.contentEquals(EXIT)) {
            terminate(baseballGame);
            return;
        }
        throw new IllegalArgumentException("invalid user input"); // TODO: 상수화 시킬 것!
    }

    private void restart(BaseballGame baseballGame) {
        baseballGame.restart();
    }

    private void terminate(BaseballGame baseballGame) {
        baseballGame.terminate();
    }
}
