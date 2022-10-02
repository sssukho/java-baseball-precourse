package baseball.controller.console;

import baseball.controller.Controller;
import baseball.model.Round;
import baseball.model.Round.Status;
import baseball.model.GameService;
import baseball.model.Score;
import baseball.model.User;
import baseball.utils.MessageGenerator;
import baseball.utils.Validator;
import baseball.view.View;
import camp.nextstep.edu.missionutils.Console;

public class ConsoleController implements Controller {
    private static final String NEW_GAME = "1";
    private static final String EXIT = "2";

    private final View view;
    private final GameService gameService;

    public ConsoleController(View view, GameService gameService) {
        this.view = view;
        this.gameService = gameService;
    }

    @Override
    public void start() {
        Round round = new Round(Status.INIT);
        while (round.getStatus() == Status.INIT || round.getStatus() == Status.PLAYING) {
            User user = new User(inputRandomNumber());
            round.setUser(user);
            Score resultScore = gameService.match(round);
            view.printScore(MessageGenerator.generateScoreMessage(resultScore));
        }
        String userInput = inputContinueGame();
        Validator.validateUserContinueInput(userInput);
        decideRestart(userInput, round);
    }

    private String inputRandomNumber() {
        view.printRandomNumberInputMessage();
        return Console.readLine();
    }

    private String inputContinueGame() {
        view.printContinueGameInputMessage();
        return Console.readLine();
    }

    private void decideRestart(String userInput, Round round) {
        if (userInput.contentEquals(NEW_GAME)) {
            start();
            return;
        } else if (userInput.contentEquals(EXIT)) {
            terminate(round);
            return;
        }
        throw new IllegalArgumentException("invalid user input"); // TODO: 상수화 시킬 것!
    }

    private void terminate(Round round) {
        round.setStatus(Status.EXIT);
    }
}
