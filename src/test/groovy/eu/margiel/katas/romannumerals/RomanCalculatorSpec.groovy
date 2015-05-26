package eu.margiel.katas.romannumerals
import spock.lang.Specification
import spock.lang.Unroll

class RomanCalculatorSpec extends Specification {
    @Unroll("adding  #num1 and #num2 should equal #result")
    def "should add two numerals"() {
        given:
          def calculator = new RomanCalculator()

        expect:
          calculator.add(num1, num2) == result

        where:
          num1  | num2   || result
          "I"   | "I"    || "II"
          "I"   | "II"   || "III"
          "II"  | "II"   || "IV"
          "III" | "II"   || "V"
          "III" | "III"  || "VI"
          "V"   | "V"    || "X"
          "IV"  | "I"    || "V"
          "IV"  | "VI"   || "X"
          "X"   | "X"    || "XX"
          "X"   | "V"    || "XV"
          "I"   | "IX"   || "X"
          "VI"  | "XXVI" || "XXXII"
          "L"   | "L"    || "C"
          "XL"  | "XL"   || "LXXX"
          "L"   | "XL"   || "XM"
    }
}
