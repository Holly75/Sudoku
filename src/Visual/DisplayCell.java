
package Visual;

import java.awt.*;

import javax.swing.*;

import Logic.Cell;

public class DisplayCell extends JPanel {

    private Board board;
    private int id;
    private Cell cell;
    private JLabel text;
    private JLabel[] pencil;
    private static Font pencilFont, lockedFont, markFont;
    private static int fontSize = 12;
    private static int pencilGap = 2;

    public DisplayCell(Board board, int id, Cell cell) {
        this.board = board;
        this.id = id;
        this.cell = cell;
        pencil = new JLabel[cell.getMaxvalue()];
        text = new JLabel();
        int fontSize = this.getPreferredSize().height;
        ;

    }

    public void drawMarks() {

        if (cell.isFilled()) {
            setLayout(new BorderLayout());
            text.setText(String.valueOf(board.textvalues[cell.getValue()]));
            text.setVerticalAlignment(SwingConstants.CENTER);
            text.setHorizontalAlignment(SwingConstants.CENTER);

            text.setFont(markFont);
            this.add(text, BorderLayout.CENTER);
        } else {
            drawpencils();
        }

    }

    private void drawpencils() {

        int maxValue = cell.getMaxvalue();
        int gridSize = (int)Math.sqrt(maxValue);
        removeAll();
        setLayout(new GridLayout(gridSize, gridSize, pencilGap, pencilGap));
        pencil = new JLabel[maxValue];
        boolean[] cellPencils = cell.getPencils();
        for (int i = 0; i < maxValue; i++) {
            if (cellPencils[i]) {
                pencil[i] = new JLabel(String.valueOf(board.textvalues[i + 1]), SwingConstants.CENTER);

            } else {
                pencil[i] = new JLabel(String.valueOf(board.textvalues[0]), SwingConstants.CENTER);
            }
            pencil[i].setFont(pencilFont);
            add(pencil[i]);
        }

    }

    void calculateFontSize(int zoneSize) {
        int fontSize = this.getPreferredSize().height;
        markFont = new Font("SansSerif", Font.PLAIN, fontSize);
        pencilFont = new Font("SansSerif", Font.PLAIN, (int)(fontSize / Math.sqrt(zoneSize)));
        lockedFont = new Font("SansSerif", Font.BOLD, fontSize);
    }

    public int getId() {
        return id;
    }

    public boolean setPencil(int pencilMark, boolean value) {
        return cell.setPencil(pencilMark, value);
    }

    public int getMaxValue() {
        return cell.getMaxvalue();
    }
}
