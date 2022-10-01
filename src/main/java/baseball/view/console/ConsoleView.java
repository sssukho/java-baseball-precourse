package baseball.view.console;

import baseball.view.View;

public class ConsoleView implements View {
    private static final String RANDOM_NUMBER_INPUT_MESSAGE = "숫자를 입력해주세요: ";

    @Override
    public void printRandomNumberInputMessage() {
        System.out.print(RANDOM_NUMBER_INPUT_MESSAGE);
    }
}
