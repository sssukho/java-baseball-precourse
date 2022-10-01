package baseball.model;

import baseball.model.Game.Status;
import baseball.utils.NumberGenerator;
import baseball.view.View;

public class GameService {
    private static final int GENERATE_RANDOM_NUM_SIZE = 3;
    private static final int GENERATE_RANDOM_NUM_RANGE_START = 1;
    private static final int GENERATE_RANDOM_NUM_RANGE_END = 9;

    private final View view;

    public GameService(View view) {
        this.view = view;
    }

    public void match(Game game) {
        generateComputerRandomNumbersIfAbsent(game);
    }

    private void generateComputerRandomNumbersIfAbsent(Game game) {
        if (game.getStatus() == Status.INIT) {
            game.setComputer(new Computer(
                    NumberGenerator.generateRandomNumberMap(GENERATE_RANDOM_NUM_SIZE, GENERATE_RANDOM_NUM_RANGE_START,
                            GENERATE_RANDOM_NUM_RANGE_END)));
        }
    }
}
