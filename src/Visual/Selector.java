/*
 * Selector.java
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

import java.awt.*;
import java.awt.event.ActionEvent;

import javax.swing.*;

public class Selector extends JPanel {
    private static final Color CL_SELECTED_BUTTON=Color.lightGray;
    private static final Color CL_UNSELECTED_BUTTON=Color.cyan;
    private int zoneSize;
    private int selectedNumber = 0;
    private boolean pencilSelected = false;

    private JButton[] buttons;
    private int extrabuttons = 3;

    public Selector(int zoneSize) {
        super();
        this.zoneSize = zoneSize;
        buttons = new JButton[zoneSize + extrabuttons];
        setLayout(new GridLayout(2, zoneSize, 2, 2));
        for (int i = 0; i < zoneSize; i++) {
            buttons[i] = createbutton(Integer.toString(i + 1));
            buttons[i].addActionListener(new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    selectedNumber = i + 1;
                    updateSelector();
                }
            });
            add(buttons[i]);
        }
        buttons[zoneSize + 0] = createbutton("Pencil");
        buttons[zoneSize + 1] = createbutton("Undo");
        buttons[zoneSize + 2] = createbutton("Reset");
        for (int i = 0; i < 3; i++) {
            add(buttons[zoneSize + i]);
        }
        setVisible(true);
    }

    private void updateSelector() {
        for (int i = 0; i < zoneSize; i++) {
            buttons[i].setBackground((i == selectedNumber - 1) ? CL_SELECTED_BUTTON : CL_UNSELECTED_BUTTON);

        }
    }

    private JButton createbutton(String caption) {
        JButton newButton = new JButton(caption);
        return newButton;
    }
}
