package eu.margiel.katas.romannumerals

import spock.lang.Specification
import spock.lang.Unroll

class NumeralsConverterSpec extends Specification {
    private def converter = new NumeralsConverter()

    @Unroll("should convert #number")
    def "should convert number"() {
        expect:
          converter.asRoman(number) == roman
        where:
          number || roman
          1      || "I"
          2      || "II"
          3      || "III"
          4      || "IV"
          5      || "V"
          6      || "VI"
          7      || "VII"
          8      || "VIII"
          9      || "IX"
          10     || "X"
          11     || "XI"
          14     || "XIV"
          18     || "XVIII"
          20     || "XX"
          25     || "XXV"
          40     || "XL"
          50     || "L"
          70     || "LXX"
          99     || "XCIX"
          121    || "CXXI"
          400    || "CD"
          500    || "D"
          900    || "CM"
          1000   || "M"
          3051   || "MMMLI"
    }
}
