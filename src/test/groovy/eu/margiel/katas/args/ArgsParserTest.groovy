package eu.margiel.katas.args

import spock.lang.Specification
import spock.lang.Unroll

class ArgsParserTest extends Specification {

    def "should get empty 's' string flag"() {
        given:
          def parser = new ArgsParser(new StringFlag("s"));

        when:
          parser.parse("-s");

        then:
          parser.get("s") == ""
    }

    def "should get 0 for empty 'i' integer flag"() {
        given:
          def parser = new ArgsParser(new IntFlag("i"));

        when:
          parser.parse("-i");

        then:
          parser.get("i") == 0
    }

    def "should get 'false' for empty 'b' boolean flag"() {
        given:
          def parser = new ArgsParser(new BoolFlag("b"));

        when:
          parser.parse("-b");

        then:
          parser.get("b") == false
    }

    def "should get value of string flag"() {
        given:
          def parser = new ArgsParser(new StringFlag("a"));

        when:
          parser.parse("-a", "value")

        then:
          parser.get("a") == "value"
    }

    def "should get values of two string flags"() {
        given:
          def parser = new ArgsParser(new StringFlag("a"), new StringFlag("b"));

        when:
          parser.parse("-a", "value1", "-b", "value2")

        then:
          parser.get("a") == "value1"
          parser.get("b") == "value2"
    }

    def "should get values for integer flag"() {
        given:
          def parser = new ArgsParser(new IntFlag("a"));

        when:
          parser.parse("-a", "1")

        then:
          parser.get("a") == 1
    }

    @Unroll
    def "should get value for boolean flag"() {
        given:
          def parser = new ArgsParser(new BoolFlag("a"));

        when:
          parser.parse("-a", arg)

        then:
          parser.get("a") == result

        where:
          arg     || result
          "true"  || true
          "True"  || true
          "TRUE"  || true
          "false" || false
          "False" || false
          "FALSE" || false


    }

    def "should get default values for two integer flags"() {
        given:
          def parser = new ArgsParser(new IntFlag("a"), new IntFlag("b"));

        when:
          parser.parse("-a", "-b")

        then:
          parser.get("a") == 0
          parser.get("b") == 0
    }

    @Unroll
    def "should throw exception if number flag got invalid value"() {
        given:
          def parser = new ArgsParser(new IntFlag(flag));

        when:
          parser.parse("-${flag}", value)

        then:
          def ex = thrown(RuntimeException);
          ex.message == "Flag '${flag}' should be a number"
        where:
          flag | value
          "c"  | "abc"
          "z"  | "true"
    }

    @Unroll
    def "should throw exception if boolean flag got invalid value"() {
        given:
          def parser = new ArgsParser(new BoolFlag(flag));

        when:
          parser.parse("-${flag}", value)

        then:
          def ex = thrown(RuntimeException);
          ex.message == "Flag '${flag}' should have a value true or false"
        where:
          flag | value
          "a"  | "1"
          "b"  | "abc"
    }

    def "should allow negative values for numeral flags"() {
        given:
          def parser = new ArgsParser(new IntFlag("k"));

        when:
          parser.parse("-k", "-10")

        then:
          parser.get("k") == -10
    }
}
