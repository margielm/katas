package eu.margiel.katas.calculator;

import java.util.Arrays;
import java.util.regex.Matcher;

import static java.util.regex.Pattern.compile;

public class StringCalculator {

    public int add(final String numbers) {
        if (numbers.length() == 0) {
            return 0;
        }
        return Arrays.stream(getArrayOfValues(numbers))
            .mapToInt(Integer::parseInt)
            .sum();
    }

    private String[] getArrayOfValues(String numbers) {
        String delimiter = getDelimiter(numbers);
        return numbers
            .replaceAll("//" + delimiter + "\\n", "")
            .split(delimiter);
    }

    private String getDelimiter(String numbers) {
        String delimiter = "[,|\\n]";
        Matcher matcher = compile("//(.)\\n").matcher(numbers);
        if (matcher.find()){
            delimiter = matcher.group(1);
        }
        return delimiter;
    }
}
