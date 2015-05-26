package eu.margiel.katas.romannumerals;

import java.util.LinkedHashMap;
import java.util.Map;

public class NumeralsConverter {

    Map<Integer, String> numberToRoman = new LinkedHashMap<>();

    {
        numberToRoman.put(1000, "M");
        numberToRoman.put(900, "CM");
        numberToRoman.put(500, "D");
        numberToRoman.put(400, "CD");
        numberToRoman.put(100, "C");
        numberToRoman.put(90, "XC");
        numberToRoman.put(50, "L");
        numberToRoman.put(40, "XL");
        numberToRoman.put(10, "X");
        numberToRoman.put(9, "IX");
        numberToRoman.put(5, "V");
        numberToRoman.put(4, "IV");
        numberToRoman.put(1, "I");
    }

    public String asRoman(int number) {
        String roman = "";
        for (Map.Entry<Integer, String> entry : numberToRoman.entrySet()) {
            while (number >= entry.getKey()) {
                roman += entry.getValue();
                number -= entry.getKey();
            }
        }
        return roman;
    }

}
