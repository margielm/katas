package eu.margiel.katas.bowling;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private List<Integer> rolls = new ArrayList<>();

    public void roll(int pins) {
        rolls.add(pins);
    }

    public int score() {
        int score = rolls.stream().mapToInt(Integer::intValue).sum();
        if (isSpare(0)) {
            score += rolls.get(2);
        }
        if (isSpare(1)) {
            score += rolls.get(4);
        }
        return score;
    }

    private boolean isSpare(int frame) {
        return rolls.get(frame*2) + rolls.get(frame*2+1) == 10;
    }
}
