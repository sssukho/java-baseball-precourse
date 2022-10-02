package baseball.view.console;

import baseball.view.View;

public class ConsoleView implements View {
    private static final String RANDOM_NUMBER_INPUT_MESSAGE = "숫자를 입력해주세요: ";
    private static final String CONTINUE_GAME_INPUT_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n";

    @Override
    public void printRandomNumberInputMessage() {
        System.out.print(RANDOM_NUMBER_INPUT_MESSAGE);
    }

    @Override
    public void printScore(String refinedScoreMessage) {
        System.out.print(refinedScoreMessage);
    }

    @Override
    public void printContinueGameInputMessage() {
        System.out.print(CONTINUE_GAME_INPUT_MESSAGE);
    }
}
