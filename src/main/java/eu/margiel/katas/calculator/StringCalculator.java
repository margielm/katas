package eu.margiel.katas.calculator;


import java.util.Arrays;
import java.util.function.Supplier;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.regex.Pattern.compile;

public class StringCalculator {

    public int add(final String numbers) {
        if (numbers.length() == 0) {
            return 0;
        }
        Supplier<IntStream> supplier = getNumberStreamSupplier(numbers);
        validateNumbers(supplier.get());
        return supplier.get().filter(number -> number <= 1000).sum();
    }

    private Supplier<IntStream> getNumberStreamSupplier(String numbers) {
        return () -> Arrays.stream(getArrayOfValues(numbers)).mapToInt(Integer::parseInt);
    }

    private void validateNumbers(IntStream stream) {
        String negative = stream
            .filter(number -> number < 0)
            .boxed()
            .map(String::valueOf)
            .collect(Collectors.joining(", "));
        if (negative.length() > 0) {
            throw new IllegalArgumentException("negatives not allowed: ");
        }
    }

    private String[] getArrayOfValues(String numbers) {
        return numbers
            .replaceAll("//.*\\n", "")
            .split(getDelimiter(numbers));
    }

    private String getDelimiter(String numbers) {
        String delimiter = ",|\\n";
        Matcher delimiterRedefined = compile("//(.+)\\n").matcher(numbers);
        if (delimiterRedefined.find()) {
            delimiter = Arrays.stream(delimiterRedefined.group(1).split("[\\[\\]]"))
                .filter(value -> value.length() > 0)
                .map(Pattern::quote)
                .collect(Collectors.joining("|"));
        }
        return delimiter;
    }
}
