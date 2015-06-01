package eu.margiel.katas.minesweeper

import spock.lang.Specification

class MineSweeperSpec extends Specification {
    private def sweeper = new MineSweeper()

    def "should return same field if mines on all spaces"() {
        expect:
          doSwipe(
              "1 1",
              "*"
          ) == result(
              "Field #1:",
              "*"
          )
    }


    def "should have no mines"() {
        expect:
          doSwipe(
              "1 1",
              "."
          ) == result(
              "Field #1:",
              "0"
          )
    }

    def "should have 1 mine in one row"() {
        expect:
          doSwipe(
              "1 2",
              "*."
          ) == result(
              "Field #1:",
              "*1"
          )
    }

    def "should have 2 mines next to each other in one row"() {
        expect:
          doSwipe(
              "1 3",
              "**."
          ) == result(
              "Field #1:",
              "**1"
          )
    }

    def "should have 2 mines next to empty space in one row"() {
        expect:
          doSwipe(
              "1 3",
              "*.*"
          ) == result(
              "Field #1:",
              "*2*"
          )
    }

    def "should have 2 mines next each other in one column"() {
        expect:
          doSwipe(
              "3 1",
              "*",
              "*",
              "."

          ) == result(
              "Field #1:",
              "*",
              "*",
              "1"
          )
    }

    def "should have 2 mines next to empty space in column"() {
        expect:
          doSwipe(
              "3 1",
              "*",
              ".",
              "*"

          ) == result(
              "Field #1:",
              "*",
              "2",
              "*"
          )
    }

    def "should have 8 mines next to empty space"() {
        expect:
          doSwipe(
              "3 3",
              "***",
              "*.*",
              "***"

          ) == result(
              "Field #1:",
              "***",
              "*8*",
              "***"
          )
    }
//    def "should swipe 2 fields"() {
//        expect:
//          doSwipe(
//              "1 1",
//              "*",
//              "2,2",
//              "..",
//              "**"
//
//          ) == result(
//              "Field #1:",
//              "*",
//              "",
//              "Field #2:",
//              "22",
//              "**"
//          )
//    }

    def doSwipe(String... lines) {
        sweeper.swipe(lines.join("\n"))
    }

    def result(String... lines) {
        return lines.join("\n")
    }


}
