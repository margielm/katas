package eu.margiel.katas.numberinwords

import spock.lang.Specification
import spock.lang.Unroll

class NumberInWordsConverterTest extends Specification {
    private def converter = new NumberInWordsConverter()

    @Unroll
    def "should convert single number to word"() {
        expect:
          converter.toWords(number) == words
        where:
          number || words
          0      || "zero"
          1      || "one"
          2      || "two"
          3      || "three"
          4      || "four"
          5      || "five"
          6      || "six"
          7      || "seven"
          8      || "eight"
          9      || "nine"
          10     || "ten"
          11     || "eleven"
          12     || "twelve"
          13     || "thirteen"
          14     || "fourteen"
          15     || "fifteen"
          16     || "sixteen"
          17     || "seventeen"
          18     || "eighteen"
          19     || "nineteen"
    }

    @Unroll
    def "should convert dozens to word"() {
        expect:
          converter.toWords(number) == words
        where:
          number || words
          20     || "twenty"
          30     || "thirty"
          40     || "forty"
          40     || "forty"
          50     || "fifty"
          60     || "sixty"
          70     || "seventy"
          80     || "eighty"
          90     || "ninety"
    }

    @Unroll
    def "should convert hundreds to word"() {
        expect:
          converter.toWords(number) == words
        where:
          number || words
          100    || "one hundred"
          200    || "two hundred"
          300    || "three hundred"
          400    || "four hundred"
    }

    @Unroll
    def "should convert complex numbers below 100 to word"() {
        expect:
          converter.toWords(number) == words
        where:
          number || words
          21     || "twenty one"
          29     || "twenty nine"
          35     || "thirty five"
          99     || "ninety nine"
    }

    @Unroll
    def "should convert complex numbers between 100 and 1000 to word"() {
        expect:
          converter.toWords(number) == words
        where:
          number || words
          101    || "one hundred and one"
          109    || "one hundred and nine"
          123    || "one hundred and twenty three"
          258    || "two hundred and fifty eight"
          599    || "five hundred and ninety nine"
    }

    @Unroll
    def "should convert complex numbers between 1000 and 100 0000 to word"() {
        given:
        expect:
          converter.toWords(number) == words
        where:
          number || words
          1000   || "one thousand"
    }
}
