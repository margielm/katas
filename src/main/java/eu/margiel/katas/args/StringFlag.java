package eu.margiel.katas.args;

public class StringFlag extends Flag<String> {

    public StringFlag(String name) {
        super(name, "");
    }

    @Override
    protected String parse(String value) {
        return value;
    }


}
