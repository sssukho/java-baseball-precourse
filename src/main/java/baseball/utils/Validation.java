package baseball.utils;

import java.util.Map;

public class Validation {
    private static final String COMPUTER_INVALID_MESSAGE = "invalid computer random map";

    public static void validateComputerRandomNumbers(Map<Integer, Integer> randomNumbers) { // TODO: 10줄 미만으로
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
        if (num < 1 || num > 9) {
            return true;
        }
        return false;
    }
}
