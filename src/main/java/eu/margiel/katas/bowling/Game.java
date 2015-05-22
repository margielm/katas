package eu.margiel.katas.bowling;

import java.util.ArrayList;
import java.util.List;

public class Game {

    public static final int ALL_PINS = 10;
    private List<Frame> frames = new ArrayList<>();
    private Frame currentFrame = null;

    public Game() {
        Frame previous = Frame.EMPTY;
        while (frames.size() < 9) {
            Frame frame = new Frame();
            frames.add(frame);
            previous = previous.next(frame);
        }
        frames.add(previous.next(new LastFrame()));
        currentFrame = frames.get(0);
    }

    public void roll(int pins) {
        if (currentFrame.isCompleted()) {
            currentFrame = currentFrame.next();
        }
        currentFrame.roll(pins);
    }

    public int score() {
        return frames.stream().mapToInt(Frame::score).sum();
    }

}
