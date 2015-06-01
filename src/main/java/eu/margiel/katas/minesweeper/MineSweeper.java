package eu.margiel.katas.minesweeper;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.joining;

public class MineSweeper {

    private FieldsConverter fieldsConverter = new FieldsConverter();
    private Field field = null;

    public String swipe(String fields) {
        field = fieldsConverter.asField(fields);
        return doSwipe();
    }

    private String doSwipe() {
        List<String> rows = new ArrayList<>();
        rows.add("Field #1:");
        for (int rowIdx = 0; rowIdx < field.countRows(); rowIdx++) {
            rows.add(swipeRow(rowIdx));
        }
        return rows.stream().collect(joining("\n"));
    }

    private String swipeRow(int rowIdx) {
        String row = "";
        for (int columnIdx = 0; columnIdx < field.countColumns(); columnIdx++) {
            if (field.hasMineAt(rowIdx, columnIdx)) {
                row += Field.MINE;
            } else {
                row += field.countNeighbouringMinesOf(rowIdx, columnIdx);
            }
        }
        return row;
    }

}
