package baseball.model;

import baseball.utils.Validator;
import java.util.Map;

public class Computer {
    private final Map<Integer, Integer> randomNumbers;

    public Computer(Map<Integer, Integer> generatedRandomNumbers) {
        this.randomNumbers = generatedRandomNumbers;
        Validator.validateComputerRandomNumbers(generatedRandomNumbers);
    }

    public Map<Integer, Integer> getRandomNumbers() {
        return randomNumbers;
    }
}
