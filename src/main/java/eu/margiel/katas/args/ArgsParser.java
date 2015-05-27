package eu.margiel.katas.args;

import java.util.HashMap;
import java.util.Map;

public class ArgsParser {

    private Map<String, Flag> schema = new HashMap<>();

    public ArgsParser(Flag... schema) {
        for (Flag flag : schema) {
            this.schema.put(flag.getName(), flag);
        }
    }

    public void parse(String[] args) {
        for (int idx = 0; idx < args.length; ) {
            String name = args[idx].replace("-", "");
            if (schema.get(name).setValue(getValueFor(args, idx))) {
                idx += 2;
            } else {
                idx += 1;
            }
        }
    }

    public Object get(String flag) {
        return schema.get(flag).getValue();
    }

    private String getValueFor(String[] args, int idx) {
        return args.length > idx + 1 ? args[idx + 1] : null;
    }


}
