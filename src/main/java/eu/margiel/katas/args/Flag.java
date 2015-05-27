package eu.margiel.katas.args;

abstract class Flag<TYPE> {

    private String name;
    private TYPE value;

    public Flag(String name, TYPE defaultValue) {
        this.name = name;
        this.value = defaultValue;
    }

    public String getName() {
        return name;
    }

    public TYPE getValue() {
        return value;
    }

    public boolean setValue(String value) {
        if (value != null && !value.matches("(?i)(-[a-z])")){
            this.value = parse(value);
            return true;
        }
        return false;
    }


    protected abstract TYPE parse(String value);


}
