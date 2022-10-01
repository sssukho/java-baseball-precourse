package baseball.model;

import baseball.utils.Validation;

public class User {
    private char[] randomNumCharArr;

    public User(String userInput) {
        Validation.validateUserNumberInput(userInput);
        randomNumCharArr = userInput.toCharArray();
    }

    public char[] getRandomNumCharArr() {
        return randomNumCharArr;
    }

    public void setRandomNumCharArr(char[] randomNumCharArr) {
        this.randomNumCharArr = randomNumCharArr;
    }
}
