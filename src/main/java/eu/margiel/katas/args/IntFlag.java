package eu.margiel.katas.args;

public class IntFlag extends Flag<Integer> {

    public IntFlag(String name) {
        super(name, 0);
    }

    @Override
    protected Integer parse(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new RuntimeException(String.format("Flag '%s' should be a number", getName()));
        }
    }


}
