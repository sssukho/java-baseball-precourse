package baseball.utils;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashMap;
import java.util.Map;

public class NumberGenerator {
    public static Map<Integer, Integer> generateRandomNumberMap(int generateCnt, int startInclusive, int endInclusive)  {
        Map<Integer, Integer> randomNumbers = new HashMap<>();
        while (randomNumbers.size() < generateCnt) {
            int pickedNumber = Randoms.pickNumberInRange(startInclusive, endInclusive);
            addRandomNumberToMap(pickedNumber, randomNumbers);
        }
        return randomNumbers;
    }

    private static void addRandomNumberToMap(int generatedNum, Map<Integer, Integer> randomNumbers) {
        if (randomNumbers.containsKey(generatedNum)) {
            return;
        }
        randomNumbers.put(generatedNum, randomNumbers.size());
    }
}
