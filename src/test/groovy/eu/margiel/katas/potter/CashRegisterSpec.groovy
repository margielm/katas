package eu.margiel.katas.potter

import spock.lang.Specification
import spock.lang.Unroll

import static eu.margiel.katas.potter.CashRegister.BOOK_PRICE

class CashRegisterSpec extends Specification {
    def cashRegister = new CashRegister()

    def "price should be 0 for empty cart"() {
        expect:
          cashRegister.priceFor([]) == 0.0
    }

    def "price should be 8 for one 1st book only"() {
        expect:
          cashRegister.priceFor([1]) == BOOK_PRICE
    }

    @Unroll
    def "should pay full price for 2 copies of same book"() {
        expect:
          cashRegister.priceFor(cart) == 2 * BOOK_PRICE

        where:
          cart << [
              [1, 1],
              [2, 2],
              [3, 3]
          ]
    }

    def "should get 5% discount if buying 1st and 2nd book "() {
        expect:
          cashRegister.priceFor([1, 2]) == 15.2
    }

    def "should get 10% discount if buying 1st, 2nd and 3rd book "() {
        expect:
          cashRegister.priceFor([1, 2, 3]) == 21.6
    }

    def "should pay full price for 3 copies of same book"() {
        expect:
          cashRegister.priceFor([1, 1, 1]) == 3 * BOOK_PRICE
    }

    def "should get 20% discount if buying 4 different books"() {
        expect:
          cashRegister.priceFor([1, 2, 3, 4]) == 4 * BOOK_PRICE * 0.8
    }

    def "should get 25% discount if buying 5 different books"() {
        expect:
          cashRegister.priceFor([1, 2, 3, 4, 5]) == 5 * BOOK_PRICE * 0.75
    }

    def "should get 5% discount for two copies of 1st and one 2nd"() {
        expect:
          cashRegister.priceFor([1, 1, 2]) == BOOK_PRICE + 2 * BOOK_PRICE * 0.95
    }

    def "should get price for 2 sets of 2 books size"() {
        expect:
          cashRegister.priceFor([1, 2, 1, 2]) == 4 * BOOK_PRICE * 0.95
    }

    def "should get price for 2 sets of 2  and 1 set 3 books size"() {
        expect:
          cashRegister.priceFor([1, 2, 1, 2, 1, 2, 3]) == 4 * BOOK_PRICE * 0.95 + 3 * BOOK_PRICE * 0.9
    }


}
