package eu.margiel.katas.calculator;


import java.util.Arrays;
import java.util.function.Supplier;
import java.util.regex.Matcher;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.regex.Pattern.compile;

public class StringCalculator {

    public int add(final String numbers) {
        if (numbers.length() == 0) {
            return 0;
        }
        Supplier<IntStream> supplier = () -> Arrays.stream(getArrayOfValues(numbers)).mapToInt(Integer::parseInt);

        validateNumbers(supplier.get());

        return supplier.get().sum();
    }

    private void validateNumbers(IntStream stream) {
        String negative = stream
            .filter(number -> number < 0)
            .boxed()
            .map(String::valueOf)
            .collect(Collectors.joining(", "));

        if (negative.length() > 0) {
            throw new IllegalArgumentException("negatives not allowed: " + negative);
        }
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
        if (matcher.find()) {
            delimiter = matcher.group(1);
        }
        return delimiter;
    }
}
