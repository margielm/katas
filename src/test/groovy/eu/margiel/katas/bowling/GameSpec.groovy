package eu.margiel.katas.bowling

import spock.lang.Specification

/**
 * Created by margielm on 21.05.2015.
 */
class GameSpec extends Specification {

    private def game = new Game();

    def "should score 0 points"() {

        when:
          rollMultiple(20, 0)

        then:
          game.score() == 0
    }

    private rollMultiple(Integer times, Integer score) {
        (1..times).forEach({
            game.roll(score)
        })
    }

    def "should score 20 points if scored 1 in every roll"() {

        when:
          rollMultiple(20, 1)

        then:
          game.score() == 20
    }

    def "should score one spares"() {

        when:
          spare(5,5)
          1.times({game.roll(3)})
          1.times({game.roll(3)})
          16.times({game.roll(0)})

        then:
          game.score() == 19
    }

    def "should score two subsequent spares"() {

        when:
          spare(5,5)
          spare(3,7)
          1.times({game.roll(1)})
          16.times({game.roll(0)})

        then:
          game.score() == 25
    }

    def "should score one strike and one point"() {

        when:
          game.roll(10)
          game.roll(1)
          17.times({game.roll(0)})

        then:
          game.score() == 12
    }

    def "should score one strike and whole next frame"() {

        when:
          game.roll(10)
          2.times({game.roll(1)})
          16.times({game.roll(0)})

        then:
          game.score() == 14
    }
    def "should score two subsequent strikes and one pin"() {

        when:
          game.roll(10)
          game.roll(10)
          game.roll(1)
          15.times({game.roll(0)})

        then:
          game.score() == 33
    }

    def "should score three subsequent strikes and one pin"() {

        when:
          game.roll(10)
          game.roll(10)
          game.roll(10)
          game.roll(5)
          13.times({game.roll(0)})

        then:
          game.score() == 70
    }

    def "should score perfec game"() {

        when:
          12.times({game.roll(10)})

        then:
          game.score() == 300
    }

    private void spare(int first, int second) {
        game.roll(first)
        game.roll(second)
    }
}
