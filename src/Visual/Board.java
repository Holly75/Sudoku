
package Visual;

import javax.swing.*;

import Logic.Field;

public class Board extends JFrame {
    private static final int MIN_CELL_GAP = 2;
    private static final int MIN_CELL_SIZE = 20;
    private static final int MIN_MARGIN = 2;
    private Field field;
    private int fieldWidth, fieldHeight, cellGap, margin, cellSize, cellCount;

    private DisplayCell[] Cells;

    public Board(Field field) {
        this.field = field;

    }

    public void reset() {
        fieldWidth = field.getWidth();
        fieldHeight = field.getHeight();
        cellCount = fieldWidth * fieldHeight;
        cellGap = MIN_CELL_GAP;
        margin = MIN_MARGIN;
        cellSize = (Math.min(getWidth(), getHeight()) - 2 * margin - (Math.max(fieldHeight, fieldWidth) - 1) * cellGap) / (Math.max(fieldHeight, fieldWidth));
        System.out.println("Frame width: " + this.getWidth() + " Height: " + getHeight() + " gap:" + cellGap + " cellsize: " + cellSize);

    }



    public void drawBoard() {
        int width = field.getWidth();
        int height = field.getHeight();
        int zoneSize = field.getZoneSize();
        String line;
        String separator = "*************";
        System.out.println(separator);
        for (int y = 0; y < height; y++) {
            line = "*";
            for (int x = 0; x < width; x++) {
                line += field.getCellValue(x + y * width);
                if (x % 3 == 2)
                    line += "*";
            }
            System.out.println(line);
            if (y % 3 == 2)
                System.out.println(separator);
        }
    }

}
