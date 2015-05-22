package eu.margiel.katas.fizzbuzz;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static java.util.stream.IntStream.rangeClosed;

public class FizzBuzz {


    public static final String FIZZ = "FIZZ";
    public static final String BUZZ = "BUZZ";

    public List<String> get() {
        return rangeClosed(1, 100)
            .boxed()
            .map(value -> {
                if (value % 15 == 0) {
                    return FIZZ + BUZZ;
                } else if (value % 3 == 0) {
                    return FIZZ;
                } else if (value % 5 == 0) {
                    return BUZZ;
                } else {
                    return value + "";
                }
            }).collect(toList());

    }
}
