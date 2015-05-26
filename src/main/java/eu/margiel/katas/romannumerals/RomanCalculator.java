package eu.margiel.katas.romannumerals;

public class RomanCalculator {

    public String add(String num1, String num2) {
        String result = simplify(num1) + simplify(num2);
        String grupped = groupAll("M", result)
            + groupAll("L", result)
            + groupAll("X", result)
            + groupAll("V", result)
            + groupAll("I", result);
        return grupped
            .replaceAll("IIIII", "V")
            .replaceAll("IIII", "IV")
            .replaceAll("VV", "X")
            .replaceAll("XXXXX", "L")
            .replaceAll("LXXXX", "XM")
            .replaceAll("XXXX", "XL")
            .replaceAll("LL", "C");

    }

    private String groupAll(String m, String result) {
        int length = result.length() - result.replace(m, "").length();
        result = "";
        while (length-- > 0) {
            result += m;
        }
        return result;
    }

    private String simplify(String numeral) {
        return numeral
            .replaceAll("XL", "XXXX")
            .replaceAll("IX", "VIIII")
            .replaceAll("IV", "IIII");
    }
}
