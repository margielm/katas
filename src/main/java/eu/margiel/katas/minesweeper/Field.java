package eu.margiel.katas.minesweeper;

import static java.util.stream.IntStream.rangeClosed;

class Field {

    public static final int ROWS = 0;
    public static final int COLUMNS = 1;
    public static final char MINE = '*';
    private char[][] matrix;

    public Field(char[][] matrix) {
        this.matrix = matrix;
    }

    public int countRows() {
        return matrix.length;
    }

    double countColumns() {
        return matrix[0].length;
    }

    boolean hasMineAt(int rowIdx, int columnIdx) {
        try {
            return matrix[rowIdx][columnIdx] == MINE;
        } catch (Exception e) {
            return false;
        }
    }


    int countNeighbouringMinesOf(int rowIdx, int columnIdx) {
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

}
