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

    @Unroll("should override delimiter with #delimiter")
    def "should override delimiter"() {
        expect:
          doAdd("//${delimiter}\n1${delimiter}2${delimiter}3${delimiter}4") == 10
        where:
          delimiter << [";", "-"]
    }

    def "should throw exception if has negative numbers"() {
        when:
          doAdd("1,-100,-200")
        then:
          def ex = thrown(IllegalArgumentException)
          ex.message =="negatives not allowed: -100, -200"
    }

    def "should ignore values more than 1000"() {
        expect:
          doAdd("1000,1001,1002") == 1000
    }

    def "should allow delimiters of any length"() {
        expect:
          doAdd("//[***]\n1***2***3***4") == 10
    }


    private def doAdd(String numbers) {
        calculator.add(numbers)
    }
}
