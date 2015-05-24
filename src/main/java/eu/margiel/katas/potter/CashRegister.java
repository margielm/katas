package eu.margiel.katas.potter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.math.BigDecimal.ONE;
import static java.math.BigDecimal.ZERO;

public class CashRegister {

    public static final BigDecimal BOOK_PRICE = new BigDecimal("8");
    private Map<Integer, String> discounts = new HashMap<Integer, String>() {
        {
            put(1, "0");
            put(2, "0.05");
            put(3, "0.10");
            put(4, "0.20");
            put(5, "0.25");
        }
    };

    public BigDecimal priceFor(List<Integer> cart) {
        return discoverSetsIn(cart)
            .stream()
            .map(BigDecimal::new)
            .reduce(ZERO, (price, set) ->
                {
                    BigDecimal setPrice = set.multiply(BOOK_PRICE).multiply(ONE.subtract(new BigDecimal(discounts.get(set.intValue()))));
                    return price.add(setPrice);
                }
            );
    }

    private List<Integer> discoverSetsIn(List<Integer> cart) {
        List<Integer> sets = new ArrayList<>();
        int setIdx = 0;
        while (!cart.isEmpty()) {
            for (Integer book = 1; book <= 5; book++) {
                if (cart.remove(book)) {
                    if (sets.size() <= setIdx) {
                        sets.add(0);
                    }
                    sets.set(setIdx, sets.get(setIdx) + 1);
                }
            }
            setIdx++;
        }
        return sets;
    }

}
