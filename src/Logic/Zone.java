/*
 * Zone.java
 * 
 * Copyright (c) 2017 by General Electric Company. All rights reserved.
 * 
 * The copyright to the computer software herein is the property of
 * General Electric Company. The software may be used and/or copied only
 * with the written permission of General Electric Company or in accordance
 * with the terms and conditions stipulated in the agreement/contract
 * under which the software has been supplied.
 */
package Logic;

/**
 * Created by 212596044 on 7/24/2017.
 */
public class Zone {
    private int size;
    private Cell[] cells;

    public Zone(int size) {
        this.size = size;
        cells=new Cell[size];
    }

    public void addCell(int number,Cell cell){
        cells[number]=cell;
    }

}
