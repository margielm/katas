package eu.margiel.katas.bowling;

import java.util.ArrayList;
import java.util.List;

public class Frame {

    public static final Frame EMPTY = new Frame();
    public static final int ALL_PINS = 10;
    private List<Integer> rolls = new ArrayList<>();
    private Frame next;


    public Frame next(Frame next) {
        this.next = next;
        return next;
    }

    public boolean isCompleted() {
        return rolls.size() == 2 || selfScore() == ALL_PINS;
    }

    public  Frame next() {
        return next;
    }

    public void roll(int pins) {
        rolls.add(pins);
    }

    public int score() {
        if (isSpare()) {
            return ALL_PINS + nextRoll();
        } else if (isStrike()) {
            return ALL_PINS + next.bonusForPreviousFrameStrike();
        } else {
            return selfScore();
        }
    }

    private Integer nextRoll() {
        return next.getRoll(0);
    }

    private boolean isStrike() {
        return getRoll(0) == ALL_PINS;
    }

    Integer getRoll(int index) {
        return rolls.get(index);
    }

    int bonusForPreviousFrameStrike() {
        return selfScore() + (isStrike() ? next.getRoll(0) : 0);
    }


    int selfScore() {
        return rolls.stream().mapToInt(Integer::intValue).sum();
    }

    private  boolean isSpare() {
        return selfScore() == ALL_PINS && rolls.size() == 2;
    }
}
