
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
    static final Character[] textvalues = {' ', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G'};
    private DisplayCell[] cells;
    private JPanel mainPanel;
    private Selector selector;

    public Board(Field field) {
        this.field = field;
        mainPanel = new JPanel();
        setLayout(new BorderLayout());
        mainPanel.setAlignmentX(Component.TOP_ALIGNMENT);

        add(mainPanel, BorderLayout.PAGE_START);
        selector = new Selector(field.getZoneSize());
        selector.setAlignmentX(Component.BOTTOM_ALIGNMENT);
        add(selector, BorderLayout.PAGE_END);

        cells = new DisplayCell[field.getHeight() * field.getWidth()];
        pack();
        this.invalidate();
    }

    public void reset() {

        mainPanel.setBounds(32, 32, 360, 360);
        setVisible(true);

        fieldWidth = field.getWidth();
        fieldHeight = field.getHeight();
        mainPanel.setLayout(new GridLayout(fieldWidth, fieldHeight, cellGap, cellGap));
        cellCount = fieldWidth * fieldHeight;
        cellGap = MIN_CELL_GAP;
        margin = MIN_MARGIN;
        DisplayCell dCell = null;
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
                dCell.setBorder(BorderFactory.createLineBorder(Color.black));
                mainPanel.add(dCell);
                cells[id] = dCell;
            }

        }
        dCell.calculateFontSize(field.getZoneSize());
        this.setVisible(true);
        //        this.add(new JButton("Test"));
        pack();
        this.invalidate();
        for (DisplayCell displayCell : cells) {
            displayCell.drawMarks();
        }
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

    public void testPencils() {
        int maxValue;

        for (DisplayCell dCell : cells) {
            maxValue = dCell.getMaxValue();
            for (int i = 0; i < maxValue; i++) {
                dCell.setPencil(i, (dCell.getId() % maxValue) != i);
            }
            dCell.drawMarks();
        }
    }

}
