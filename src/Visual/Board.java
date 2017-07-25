/*
 * Board.java
 * 
 * Copyright (c) 2017 by General Electric Company. All rights reserved.
 * 
 * The copyright to the computer software herein is the property of
 * General Electric Company. The software may be used and/or copied only
 * with the written permission of General Electric Company or in accordance
 * with the terms and conditions stipulated in the agreement/contract
 * under which the software has been supplied.
 */
package Visual;

import javax.swing.*;

import Logic.Field;

/**
 * Created by 212596044 on 7/24/2017.
 */
public class Board extends JFrame {
    private Field field;

    public Board(Field field) {
        this.field = field;
    }

    public void drawBoard(){
        int width=field.getWidth();
        int height=field.getHeight();
        int zoneSize=field.getZoneSize();
        String line;
        String separator= "*************";
        System.out.println(separator);
        for (int y = 0; y < height ; y++) {
            line="*";
            for (int x = 0; x < width ; x++) {
                line+=field.getCellValue(x+y*width);
                if (x%3==2) line+="*";
            }
            System.out.println(line);
            if (y%3==2)
                System.out.println(separator);
        }
    }

}
