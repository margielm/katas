package eu.margiel.katas.calculator

import spock.lang.Specification

class StringCalculatorSpec extends Specification {
    private def calculator = new StringCalculator()

    def "should return 0 when adding empty string"() {

        expect:
          calculator.add("") == 0
    }

    def "should return same value for adding one number"() {
        expect:
          calculator.add("1") == 1
    }

    def "should return sum of two numbers"() {
        expect:
          calculator.add("1,1") == 2

    }
}
