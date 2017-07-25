
package Visual;

import javax.swing.*;

import Logic.Cell;

import java.awt.*;

public class DisplayCell extends JPanel {

    private Board board;
    private int id;
    private Cell cell;

    public DisplayCell(Board board, int id, Cell cell) {
        this.board = board;
        this.id = id;
        this.cell = cell;
    }

}
