package baseball.utils;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Validator {
    private static final String COMPUTER_INVALID_MESSAGE = "invalid computer random map";
    private static final String INAPPROPRIATE_MESSAGE = "input length is inappropriate";
    private static final String CONTAINS_CHARACTER_MESSAGE = "user's input contains character which is not digit";
    private static final String CONTAINS_DUPLICATED_MESSAGE = "user's input contains duplicated digit";
    private static final String INVALID_RANGE = "range of input is invalid";
    private static final String NUMBER_REGEX = "[1-9]+";
    public static final int CONTINUE_INPUT_START_INCLUSIVE = 1;
    public static final int CONTINUE_INPUT_END_INCLUSIVE = 2;

    public static void validateUserNumberInput(String userInput) {
        if (userInput.length() != 3) {
            throw new IllegalArgumentException(INAPPROPRIATE_MESSAGE);
        }
        if (containsCharacter(userInput)) {
            throw new IllegalArgumentException(CONTAINS_CHARACTER_MESSAGE);
        }
        if (containsDuplicatedNumber(userInput)) {
            throw new IllegalArgumentException(CONTAINS_DUPLICATED_MESSAGE);
        }
    }

    private static boolean containsCharacter(String userInput) {
        return !userInput.matches(NUMBER_REGEX);
    }

    private static boolean containsDuplicatedNumber(String userInput) {
        Set<Character> duplicateCheck = new HashSet<>();
        for (char num : userInput.toCharArray()) {
            duplicateCheck.add(num);
        }
        return duplicateCheck.size() != 3;
    }

    public static void validateComputerRandomNumbers(Map<Integer, Integer> randomNumbers) {
        if (randomNumbers.size() != 3) {
            throw new IllegalArgumentException(COMPUTER_INVALID_MESSAGE);
        }
        boolean zeroExists = false;
        for (Integer num : randomNumbers.keySet()) {
            zeroExists = containsZero(num);
        }
        if (zeroExists) {
            throw new IllegalArgumentException(COMPUTER_INVALID_MESSAGE);
        }
    }

    private static boolean containsZero(Integer num) {
        return num < 1 || num > 9;
    }

    public static void validateUserContinueInput(String userInput) {
        if (userInput.length() != 1 ) {
            throw new IllegalArgumentException(INAPPROPRIATE_MESSAGE);
        }
        if (containsCharacter(userInput)) {
            throw new IllegalArgumentException(CONTAINS_CHARACTER_MESSAGE);
        }
        if (!containsInRange(userInput)) {
            throw new IllegalArgumentException(INVALID_RANGE);
        }
    }

    private static boolean containsInRange(String userInput) {
        int input = userInput.toCharArray()[0] - '0';
        return input <= Validator.CONTINUE_INPUT_END_INCLUSIVE && input >= Validator.CONTINUE_INPUT_START_INCLUSIVE;
    }
}
