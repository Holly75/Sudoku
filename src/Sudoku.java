import java.awt.*;

import javax.swing.*;

import Logic.Field;
import Logic.PredefinedLevels;
import Visual.Board;

public class Sudoku {

    private Board board;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Sudoku window = new Sudoku();
                    window.board.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private Sudoku() {
        initialize();
    }

    private void initialize() {
        PredefinedLevels predef = new PredefinedLevels();
        Field field = new Field(predef.getLevel(0));
        board = new Board(field);
        board.setBounds(100, 100, 730, 489);
        board.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //        board.getContentPane().setLayout(new BorderLayout());
        board.reset();
        board.drawBoard();
        board.testPencils();

    }

}
