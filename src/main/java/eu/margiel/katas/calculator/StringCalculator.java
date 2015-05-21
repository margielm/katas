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

        return supplier.get().sum();
    }

    private Supplier<IntStream> getNumberStreamSupplier(String numbers) {
        return () -> Arrays.stream(getArrayOfValues(numbers)).mapToInt(Integer::parseInt).filter(number -> number <=1000);
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
        return numbers
            .replaceAll("//.*\\n", "")
            .split(getDelimiter(numbers));
    }

    private String getDelimiter(String numbers) {
        String delimiter = "[,|\\n]";
        Matcher matcher = compile("//(.*)\\n").matcher(numbers);
        if (matcher.find()) {
            String group = matcher.group(1);
            String replace = group.replaceAll("[\\[\\]]", "");
            delimiter = Pattern.quote(replace);
        }
        return delimiter;
    }
}
