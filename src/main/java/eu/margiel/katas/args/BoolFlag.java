package eu.margiel.katas.args;

public class BoolFlag extends Flag<Boolean> {

    public BoolFlag(String name) {
        super(name, false);
    }

    @Override
    protected Boolean parse(String value) {
        if (value.matches("(?i)(true|false)")) {
            return Boolean.parseBoolean(value);
        } else {
            throw new RuntimeException(String.format("Flag '%s' should have a value true or false", getName()));
        }
    }


}
