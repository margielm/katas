package eu.margiel.katas.gameoflife;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GenerationConverter {

    static List<List<Boolean>> toMatrix(String input) {
        List<List<Boolean>> matrix = new ArrayList<>();
        for (String line : input.split("\n")) {
            List<Boolean> row = new ArrayList<>();
            for (String value : line.split(" ")) {
                row.add("*".equals(value));
            }
            matrix.add(row);
        }
        return matrix;
    }

    static String printMatrix(List<List<Boolean>> matrix) {
        String output = "";
        for (List<Boolean> rows : matrix) {
            output += rows.stream().map(cell -> cell ? "*" : ".").collect(Collectors.joining(" ", "", "\n"));
        }
        return output;
    }
}
