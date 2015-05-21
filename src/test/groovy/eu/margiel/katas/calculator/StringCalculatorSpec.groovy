package eu.margiel.katas.calculator

import spock.lang.Specification
import spock.lang.Unroll

class StringCalculatorSpec extends Specification {
    private def calculator = new StringCalculator()

    def "should return 0 when adding empty string"() {

        expect:
          doAdd("") == 0
    }

    @Unroll
    def "should return same value for adding one number"() {
        expect:
          doAdd(numbers) == result
        where:
          numbers || result
          "1"     || 1
          "2"     || 2
          "10"    || 10
    }

    def "should return sum of two numbers"() {
        expect:
          doAdd("1,1") == 2
    }


    def "should sum numbers separated by \\n"() {
        expect:
          doAdd("1\n2") == 3
    }

    def "should sum numbers separated by \\n and ,"() {
        expect:
          doAdd("1\n2,3") == 6
    }

    private def doAdd(String numbers) {
        calculator.add(numbers)
    }
}
