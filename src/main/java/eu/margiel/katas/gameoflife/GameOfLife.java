package eu.margiel.katas.gameoflife;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.IntStream.rangeClosed;

public class GameOfLife {
    private List<List<Boolean>> matrix = new ArrayList<>();

    public GameOfLife(String input) {
        matrix = GenerationConverter.toMatrix(input);
    }

    public String next() {
        return GenerationConverter.printMatrix(nextGeneration());
    }

    private List<List<Boolean>> nextGeneration() {
        List<List<Boolean>> output = new ArrayList<>();
        for (int rowIdx = 0; rowIdx < matrix.size(); rowIdx++) {
            List<Boolean> row = new ArrayList<>();
            output.add(row);
            for (int colIdx = 0; colIdx < matrix.get(rowIdx).size(); colIdx++) {
                row.add(computeNewStateOf(rowIdx, colIdx));
            }
        }
        return output;
    }

    private boolean computeNewStateOf(int rowIdx, int colIdx) {
        int numberOfAliveNeighbours = countAliveNeighboursOf(rowIdx, colIdx);
        if (isAlive(rowIdx, colIdx)) {
            return  numberOfAliveNeighbours == 2 || numberOfAliveNeighbours == 3;
        } else {
            return  numberOfAliveNeighbours == 3;
        }
    }

    private int countAliveNeighboursOf(int rowIdx, int colIdx) {
        int count = -countFor(rowIdx, colIdx);
        for (int rowShift : rangeClosed(-1, 1).toArray()) {
            for (int colShift : rangeClosed(-1, 1).toArray()) {
                count += countFor(rowIdx + rowShift, colIdx + colShift);
            }
        }
        return count;
    }

    private int countFor(int rowIdx, int colIdx) {
        return isAlive(rowIdx, colIdx) ? 1 : 0;
    }

    private boolean isAlive(int rowIdx, int colIdx) {
        try {
            return matrix.get(rowIdx).get(colIdx);
        } catch (Exception e) {
            return false;
        }
    }

}
