
package Visual;

import javax.swing.*;

import Logic.Cell;

import java.awt.*;

public class DisplayCell extends JPanel {

    private Board board;
    private int id;
    private Cell cell;
    private JLabel text;
    private JLabel[] pencil;


    public DisplayCell(Board board, int id, Cell cell) {
        this.board = board;
        this.id = id;
        this.cell = cell;
        pencil=new JLabel[cell.getMaxvalue()];
        text=new JLabel();


    }

    public void drawMarks(){
        if (cell.isFilled()){
            setLayout(new BorderLayout());
            text.setText(String.valueOf(board.textvalues[cell.getValue()]));
            this.add(text,BorderLayout.CENTER);
        }

    }


}
