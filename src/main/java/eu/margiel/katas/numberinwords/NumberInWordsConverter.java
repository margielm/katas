package eu.margiel.katas.numberinwords;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

public class NumberInWordsConverter {

    private Map<Integer, String> numberToWord = new HashMap<>();

    {
//        numberToWord.put(0, "zero");
        numberToWord.put(1, "one");
        numberToWord.put(2, "two");
        numberToWord.put(3, "three");
        numberToWord.put(4, "four");
        numberToWord.put(5, "five");
        numberToWord.put(6, "six");
        numberToWord.put(7, "seven");
        numberToWord.put(8, "eight");
        numberToWord.put(9, "nine");
        numberToWord.put(10, "ten");
        numberToWord.put(11, "eleven");
        numberToWord.put(12, "twelve");
        numberToWord.put(13, "thirteen");
        numberToWord.put(14, "fourteen");
        numberToWord.put(15, "fifteen");
        numberToWord.put(16, "sixteen");
        numberToWord.put(17, "seventeen");
        numberToWord.put(18, "eighteen");
        numberToWord.put(19, "nineteen");
        numberToWord.put(20, "twenty");
        numberToWord.put(30, "thirty");
        numberToWord.put(40, "forty");
        numberToWord.put(50, "fifty");
        numberToWord.put(60, "sixty");
        numberToWord.put(70, "seventy");
        numberToWord.put(80, "eighty");
        numberToWord.put(90, "ninety");
    }

    public String toWords(int number) {
        if (number == 0) {
            return "zero";
        }
        List<String> words = new ArrayList<>();
        words.add(number(thousands(number), "thousand"));
        words.add(number(hundreds(number), "hundred"));
        words.add(dozens(getPartOfTheNumber(number, 10) * 10 + getPartOfTheNumber(number, 1)));
        return words.stream()
            .filter(part -> !part.trim().isEmpty())
            .collect(Collectors.joining(" and "));

    }

    private int hundreds(int number) {
        return getPartOfTheNumber(number, 100);
    }

    private int thousands(int number) {
        return getPartOfTheNumber(number, 1000);
    }

    private int getPartOfTheNumber(int number, int part) {
        int remainder = number % (part * 10);
        return remainder / part;
    }

    private String number(int number, String suffix) {
        if (number > 0) {
            return say(number) + (suffix.isEmpty() ? "" : " " + suffix);
        }
        return "";
    }

    private String say(int number) {
        return ofNullable(numberToWord.get(number)).orElse("");
    }

    private String dozens(int number) {
        if (say(number).isEmpty()) {
            return say(number / 10 * 10) + " " + say(number % 10);

        }
        return say(number);
    }
}
