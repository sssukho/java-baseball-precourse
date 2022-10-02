package baseball.controller.console;

import baseball.controller.Controller;
import camp.nextstep.edu.missionutils.Console;

public class ConsoleController implements Controller {
    @Override
    public String inputRandomNumber() {
        return Console.readLine();
    }

    @Override
    public String inputContinueGame() {
        return Console.readLine();
    }
}
