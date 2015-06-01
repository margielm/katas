package eu.margiel.katas.minesweeper;

class FieldsConverter {


    Field asField(String fields) {
        String[] rows = fields.split("\n");
        char[][] matrix = initiateMatrix(rows);
        for (int rowIdx = 0; rowIdx < matrix.length; rowIdx++) {
            char[] cells = rows[rowIdx + 1].toCharArray();
            System.arraycopy(cells, 0, matrix[rowIdx], 0, cells.length);
        }
        return new Field(matrix);
    }

    private char[][] initiateMatrix(String[] rows) {
        int noOfRows = getDimension(rows, Field.ROWS);
        int noOfColumns = getDimension(rows, Field.COLUMNS);
        return new char[noOfRows][noOfColumns];
    }

    private int getDimension(String[] rows, int type) {
        return Integer.parseInt(rows[0].split(" ")[type]);
    }
}