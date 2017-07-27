
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
        int gridSize = (int)Math.sqrt(cell.getMaxvalue());
        setLayout(new GridLayout(gridSize, gridSize, pencilGap, pencilGap));
        JLabel pencil;
        for (int i = 0; i < cell.getMaxvalue(); i++) {
        }
        text.setText(String.valueOf(board.textvalues[cell.getValue()]));
        text.setVerticalAlignment(SwingConstants.CENTER);
        text.setHorizontalAlignment(SwingConstants.CENTER);

        text.setFont(markFont);
        this.add(text, BorderLayout.CENTER);

    }

    void calculateFontSize() {
        int fontSize = this.getPreferredSize().height / 2;
        markFont = new Font("SansSerif", Font.PLAIN, fontSize);
        pencilFont = new Font("SansSerif", Font.PLAIN, (int)(fontSize / Math.sqrt(cell.getMaxvalue())));
        lockedFont = new Font("SansSerif", Font.BOLD, fontSize);
    }

}
