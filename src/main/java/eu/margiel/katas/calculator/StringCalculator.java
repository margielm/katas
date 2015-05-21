package eu.margiel.katas.calculator;

public class StringCalculator {

    public int add(final String numbers) {
        if (numbers.length() == 0) {
            return 0;
        }
        return numbers.split(",").length;
    }
}
