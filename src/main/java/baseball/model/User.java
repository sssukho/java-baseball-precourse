package baseball.model;

import baseball.utils.Validator;

public class User {
    private final char[] randomNumCharArr;

    public User(String userInput) {
        Validator.validateUserNumberInput(userInput);
        randomNumCharArr = userInput.toCharArray();
    }

    public char[] getRandomNumCharArr() {
        return randomNumCharArr;
    }
}
