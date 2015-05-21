package eu.margiel.katas.calculator;

import java.util.Arrays;

public class StringCalculator {

    public int add(final String numbers) {
        if (numbers.length() == 0) {
            return 0;
        }
        return Arrays.stream(numbers.split(","))
            .mapToInt(Integer::parseInt)
            .sum();
    }
}
