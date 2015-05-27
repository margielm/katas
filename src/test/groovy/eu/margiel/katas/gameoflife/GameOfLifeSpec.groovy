package eu.margiel.katas.gameoflife

import spock.lang.Specification

class GameOfLifeSpec extends Specification {
    def gameOfLife

    def "should have no living cells"() {
        given:
          def matrix = this.matrix(
              ". . ."
          )
          startWith(matrix)

        when:
          def next = gameOfLife.next();

        then:
          next == matrix

    }


    def "live cell with 0 living neighbours should die"() {
        given:
          startWith(
              matrix(
                  "* . .")
          )

        when:
          def next = gameOfLife.next();

        then:
          next == matrix(". . .")
    }

    def "live cell with 1 living neighbours should die"() {
        given:
          startWith(
              matrix(
                  "* * .")
          )

        when:
          def next = gameOfLife.next();

        then:
          next == matrix(
              ". . .")
    }

    def "live cell with 2 living neighbours should survive"() {
        given:
          startWith(matrix("* * *"))

        when:
          def next = gameOfLife.next();

        then:
          next == matrix(
              ". * .")
    }

    def "live cell with 3 living neighbours should survive"() {
        given:
          startWith(matrix(
              ". * * .",
              ". * * .")
          )

        when:
          def next = gameOfLife.next();

        then:
          next == matrix(
              ". * * .",
              ". * * .")
    }

    def "dead cell with 3 living neighbours should become alive"() {
        given:
          startWith(matrix(
              "* * .",
              "* . .")
          )

        when:
          def next = gameOfLife.next();

        then:
          next == matrix(
              "* * .",
              "* * .")
    }

    def "live cell with more than 3 living neighbours should die"() {
        given:
          startWith(matrix(
              "* * *",
              "* * *",
              "* * *")
          )

        when:
          def next = gameOfLife.next();

        then:
          next == matrix(
              "* . *",
              ". . .",
              "* . *"
          )
    }

    def "should change vertical line into horizontal"() {
        given:
          startWith(matrix(
              ". . . . .",
              ". . * . .",
              ". . * . .",
              ". . * . .",
              ". . . . .")
          )

        when:
          def next = gameOfLife.next();

        then:
          next == matrix(
              ". . . . .",
              ". . . . .",
              ". * * * .",
              ". . . . .",
              ". . . . .")
    }

    def matrix(String... lines) {
        lines.join("\n") + "\n";
    }

    def startWith(String input) {
        gameOfLife = new GameOfLife(input)
    }


}
