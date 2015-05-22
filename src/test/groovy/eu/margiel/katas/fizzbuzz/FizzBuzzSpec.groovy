package eu.margiel.katas.fizzbuzz

import spock.lang.Specification

class FizzBuzzSpec extends Specification {
    private def fizzBuzz = new FizzBuzz()

    def "should produce 100 items"() {
        expect:
          fizzBuzz.get().size == 100
    }

    def "should say the number for 1 and 1"() {
        expect:
          sayNumber(1) == "1"
          sayNumber(2) == "2"
    }

    def "should say FIZZ for 3"() {
        expect:
          sayNumber(3) == "FIZZ"
    }

    def "should say FIZZ for multiples of 3"() {
        expect:
          sayNumber(number) == "FIZZ"
        where:
          number << [3, 6, 9, 12, 36]
    }

    def "should say BUZZ for 5"() {
        expect:
          sayNumber(5) == "BUZZ"
    }

    def "should say BUZZ for multiples of 5"() {
        expect:
          sayNumber(number) == "BUZZ"
        where:
          number << [5, 10, 20, 100]
    }
    def "should say FIZZBUZZ for multiples of 3 and 5"() {
        expect:
          sayNumber(number) == "FIZZBUZZ"
        where:
          number << [15, 30, 45, 90]
    }

    private String sayNumber(int number) {
        fizzBuzz.get().get(number - 1)
    }
}
