package eu.margiel.katas.bowling;

public class LastFrame extends Frame {

    @Override
    public boolean isCompleted() {
        return false;
    }

    @Override
    public int score() {
        return selfScore();
    }

    @Override
    int bonusForPreviousFrameStrike() {
        return getRoll(0) + getRoll(1);
    }
}
