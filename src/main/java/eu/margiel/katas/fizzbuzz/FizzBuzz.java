package eu.margiel.katas.fizzbuzz;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static java.util.stream.IntStream.rangeClosed;

public class FizzBuzz {


    public static final String FIZZ = "FIZZ";
    public static final String BUZZ = "BUZZ";

    public List<String> get() {
        Speaker chain = new FizzSpeaker()
            .next(new BuzzSpeaker().next(new NumberSpeaker()));
        return rangeClosed(1, 100)
            .boxed()
            .map(value -> chain.handle(value, ""))
            .collect(toList());
    }

    abstract class Speaker {

        private Speaker next;

        abstract boolean accepts(int number, String word);

        abstract String doHandle(int number, String word);

        public Speaker next(Speaker next) {
            this.next = next;
            return this;
        }

        String handle(int number, String word) {
            if (accepts(number, word)) {
                word = doHandle(number, word);
            }
            if (next != null) {
                word = next.handle(number, word);
            }
            return word;
        }

    }

    class FizzSpeaker extends Speaker {

        @Override
        boolean accepts(int number, String word) {
            return number % 3 == 0;
        }

        @Override
        String doHandle(int number, String word) {
            return word + FIZZ;
        }
    }

    class BuzzSpeaker extends Speaker {

        @Override
        boolean accepts(int number, String word) {
            return number % 5 == 0;
        }

        @Override
        String doHandle(int number, String word) {
            return word + BUZZ;
        }
    }

    class NumberSpeaker extends Speaker {

        @Override
        boolean accepts(int number, String word) {
            return word.length() == 0;
        }

        @Override
        String doHandle(int number, String word) {
            return number + "";
        }
    }


}
