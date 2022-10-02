package baseball.model;

import baseball.controller.console.ConsoleController;
import baseball.view.View;
import baseball.view.console.ConsoleView;

public class BaseballGame {
    public static final String MODE_CONSOLE = "console";

    private ConsoleController controller;

    public BaseballGame(String mode) {
        init(mode);
    }

    private void init(String mode) {
        if (mode.equals(MODE_CONSOLE)) {
            initConsoleMode();
        }
    }

    private void initConsoleMode() {
        View view = new ConsoleView();
        GameService gameService = new GameService(new ScoreService());
        controller = new ConsoleController(view, gameService);
    }

    public void start() {
        controller.start();
    }
}
