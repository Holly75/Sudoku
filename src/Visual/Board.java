
package Visual;

import java.awt.*;

import javax.swing.*;

import Logic.Field;

public class Board extends JFrame {
    private static final int MIN_CELL_GAP = 2;
    private static final int MIN_CELL_SIZE = 20;
    private static final int MIN_MARGIN = 2;
    private Field field;
    private int fieldWidth, fieldHeight, cellGap, margin, cellSize, cellCount;
    static final Character[] textvalues = {' ','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F','G'};
    private DisplayCell[] cells;

    public Board(Field field) {
        this.field = field;
        cells = new DisplayCell[field.getHeight() * field.getWidth()];

    }

    public void reset() {

        setBounds(32, 32, 360, 360);
        setVisible(true);
        fieldWidth = field.getWidth();
        fieldHeight = field.getHeight();
        setLayout(new GridLayout(fieldWidth, fieldHeight, cellGap, cellGap));
        cellCount = fieldWidth * fieldHeight;
        cellGap = MIN_CELL_GAP;
        margin = MIN_MARGIN;
        DisplayCell dCell;
        cells = new DisplayCell[cellCount];
        cellSize = (Math.min(getWidth(), getHeight()) - 2 * margin - (Math.max(fieldHeight, fieldWidth) - 1) * cellGap) / (Math.max(fieldHeight, fieldWidth));
        System.out.println("Frame width: " + this.getWidth() + " Height: " + getHeight() + " gap:" + cellGap + " cellsize: " + cellSize);
        Dimension dimension = new Dimension(cellSize, cellSize);
        for (int y = 0; y < fieldHeight; y++) {
            for (int x = 0; x < fieldWidth; x++) {
                int id = x + y * fieldWidth;
                dCell = new DisplayCell(this, id, field.getCellById(id));
                dCell.setPreferredSize(dimension);
                dCell.setMinimumSize(dimension);
                dCell.setMaximumSize(dimension);
                int posX = margin + x * (cellSize + cellGap);
                int posY = margin + y * (cellSize + cellGap);
                dCell.setLocation(posX, posY);
                dCell.setEnabled(true);
                dCell.drawMarks();
                dCell.setBorder(BorderFactory.createLineBorder(Color.black));
                add(dCell);
                cells[id] = dCell;
            }

        }
        this.setVisible(true);
        //        this.add(new JButton("Test"));
        pack();
        this.invalidate();

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
