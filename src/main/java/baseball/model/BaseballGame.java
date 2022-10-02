package baseball.model;

import baseball.controller.Controller;
import baseball.controller.console.ConsoleController;
import baseball.model.Game.Status;
import baseball.utils.Validation;
import baseball.view.View;
import baseball.view.console.ConsoleView;

public class BaseballGame {
    public static final String MODE_CONSOLE = "console";

    private View view;
    private GameService gameService;
    private Controller controller;
    private String mode;
    private Game game;

    public BaseballGame(String mode) {
        init(mode);
    }

    private void init(String mode) {
        if (mode.equals(MODE_CONSOLE)) {
            initConsoleMode();
        }
    }

    private void initConsoleMode() {
        view = new ConsoleView();
        gameService = new GameService(view, new ScoreService());
        controller = new ConsoleController();
        game = new Game(Status.INIT);
        this.mode = MODE_CONSOLE;
    }

    public void start() {
        while (game.getStatus() == Status.INIT || game.getStatus() == Status.PLAYING) {
            User user = new User(inputRandomNumber());
            game.setUser(user);
            gameService.match(game);
        }
        String userInput = inputContinueGame();
        Validation.validateUserContinueInput(userInput);
        gameService.decideRestart(userInput, this);
    }

    private String inputRandomNumber() {
        view.printRandomNumberInputMessage();
        return controller.inputRandomNumber();
    }

    private String inputContinueGame() {
        view.printContinueGameInputMessage();
        return controller.inputContinueGame();
    }

    public void restart() {
        game.setStatus(Status.INIT);
        start();
    }

    public void terminate() {
        game.setStatus(Status.EXIT);
    }
}
