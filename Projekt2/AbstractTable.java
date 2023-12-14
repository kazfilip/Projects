package Projekt2;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AbstractTable extends AbstractTableModel {
    public static int [][] table;
    int width;
    int height;

    Random random = new Random();

    public AbstractTable(int width,int height){
        table = new int[width][height];

        this.width=width;
        this.height=height;

    }
    @Override
    public int getRowCount() {
        return width;
    }

    @Override
    public int getColumnCount() {
        return height;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return table[rowIndex][columnIndex];
    }
    public void generateMaze() {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                table[i][j] = 1;
            }
        }
        generatePaths(1, 1);
        addMultiplePaths();
        createBox();
        addBoundaries();
    }
    private void addBoundaries() {
        for (int col = 0; col < height; col++) {
            table[0][col] = 1;
            table[width - 1][col] = 1;
        }
        for (int row = 0; row < width; row++) {
            table[row][0] = 1;
            table[row][height - 1] = 1;
        }
    }

    public void createBox() {

        int boxFirstX = width / 2 - 2;
        int boxFirstY = height / 2 - 2;
        int boxEndX = boxFirstX + 4;
        int boxEndY = boxFirstY + 4;


        for (int i = boxFirstX; i <= boxEndX; i++) {
            for (int j = boxEndY; j <= boxEndY; j++) {
                if (i == boxFirstX || i == boxEndX || j == boxFirstY || j == boxEndY) {
                    table[i][j] = 1;
                } else {
                    table[i][j] = 3;
                }
            }
        }
    }
    public void generatePaths(int row, int col) {
        int[] directions = { 1, 2, 3, 4 };
        shuffleArray(directions);

        for (int direction : directions) {
            int newRow = row;
            int newCol = col;

            switch (direction) {
                case 1 -> newRow -= 2;
                case 2 -> newCol += 2;
                case 3 -> newRow += 2;
                case 4 -> newCol -= 2;
            }

            if (isValidMove(newRow, newCol)) {
                table[newRow][newCol] = 0; //1x3 = 0
                table[newRow + (row - newRow) / 2][newCol + (col - newCol) / 2] = 0; // 1x2 = 0
                generatePaths(newRow, newCol);
            }
        }
    }

    public boolean isValidMove(int row, int col) {
        return row >= 0 && row < width && col >= 0 && col < height && table[row][col] == 1;
    }

    public void shuffleArray(int[] array) {
        for (int i = array.length - 1; i > 0; i--) {
            int index = random.nextInt(i + 1);
            int temp = array[index];
            array[index] = array[i];
            array[i] = temp;
        }
    }

    public void addMultiplePaths() {
        List<int[]> wallCells = new ArrayList<>();
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                if (table[i][j] == 1) {
                    wallCells.add(new int[]{i, j});
                }
            }
        }
        int numPaths = wallCells.size() / 4 ;
        for (int i = 0; i < numPaths; i++) {
            int randomIndex = random.nextInt(wallCells.size());
            int[] cell = wallCells.get(randomIndex);
            table[cell[0]][cell[1]] = 0;
            wallCells.remove(randomIndex);
        }
    }
}



