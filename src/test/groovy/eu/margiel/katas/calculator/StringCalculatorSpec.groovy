package eu.margiel.katas.calculator

import spock.lang.Specification
import spock.lang.Unroll

class StringCalculatorSpec extends Specification {
    private def calculator = new StringCalculator()

    def "should return 0 when adding empty string"() {

        expect:
          calculator.add("") == 0
    }

    @Unroll
    def "should return same value for adding one number"() {
        expect:
          calculator.add(numbers) == result
        where:
          numbers || result
          "1"     || 1
          "2"     || 2
          "10"    || 10
    }

    def "should return sum of two numbers"() {
        expect:
          calculator.add("1,1") == 2
    }
}
