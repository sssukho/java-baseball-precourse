package baseball;

import baseball.model.BaseballGame;

public class Application {
    public static void main(String[] args) {
        new BaseballGame(BaseballGame.MODE_CONSOLE).start();
    }
}
