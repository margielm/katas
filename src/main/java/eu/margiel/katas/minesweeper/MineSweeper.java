package eu.margiel.katas.minesweeper;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.joining;
import static java.util.stream.IntStream.rangeClosed;

public class MineSweeper {

    public static final int ROWS = 0;
    public static final int COLUMNS = 1;
    public static final char MINE = '*';
    private final FieldsConverter fieldsConverter = new FieldsConverter();
    private char[][] matrix = null;


    public String swipe(String fields) {
        matrix = fieldsConverter.toMatrix(fields);
        return doSwipe();
    }

    private String doSwipe() {
        List<String> result = new ArrayList<>();
        result.add("Field #1:");
        for (int rowIdx = 0; rowIdx < matrix.length; rowIdx++) {
            String line = "";
            for (int columnIdx = 0; columnIdx < matrix[0].length; columnIdx++) {
                if (hasMineAt(rowIdx, columnIdx)) {
                    line += MINE;
                } else {
                    line += countNeighbourMines(rowIdx, columnIdx);
                }
            }
            result.add(line);
        }
        return result.stream().collect(joining("\n"));
    }

    private int countNeighbourMines(final int rowIdx, final int columnIdx) {
        int count = 0;
        for (int rowShift : rangeClosed(-1, 1).toArray()) {
            for (int colShift : rangeClosed(-1, 1).toArray()) {
                count += countMinesAt(rowIdx + rowShift, columnIdx + colShift);
            }
        }
        return count;
    }

    private int countMinesAt(int rowIdx, int column) {
        return hasMineAt(rowIdx, column) ? 1 : 0;
    }

    private boolean hasMineAt(int rowIdx, int columnIdx) {
        try {
            return matrix[rowIdx][columnIdx] == MINE;
        } catch (Exception e) {
            return false;
        }
    }
}
