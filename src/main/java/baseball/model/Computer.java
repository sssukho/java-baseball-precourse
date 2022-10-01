package baseball.model;

import baseball.utils.Validation;
import java.util.Map;

public class Computer {
    private Map<Integer, Integer> randomNumbers;

    public Computer(Map<Integer, Integer> generatedRandomNumbers) {
        this.randomNumbers = generatedRandomNumbers;
        Validation.validateComputerRandomNumbers(generatedRandomNumbers);
    }

    public Map<Integer, Integer> getRandomNumbers() {
        return randomNumbers;
    }
}
