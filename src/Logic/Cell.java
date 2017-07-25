/*
 * Cell.java
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

import java.util.Vector;

/**
 * Created by 212596044 on 7/24/2017.
 */
public class Cell {
    private int id;
    private boolean locked,filled;
    private int value,maxvalue;
    private boolean[] pencil;
    private Vector<Zone> zones;

    public Cell(int id,boolean locked, int value, Vector<Zone> zones) {
        this.id=id;
        this.locked = locked;
        this.zones = zones;
        if (locked){
            this.value = value;
        }
        else {
            this.maxvalue=value;
            reset();
        }



    }
    public void reset(){
        pencil=new boolean[maxvalue];
        value=0;
        filled=false;

    }

    public boolean isLocked() {
        return locked ;
    }

    public boolean isFilled() {
        return filled || locked;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        if (!locked)this.value = value;
    }

    public int getMaxvalue() {
        return maxvalue;
    }

    public boolean[] getPencil() {
        return pencil;
    }

    public Vector<Zone> getZones() {
        return zones;
    }

    public int getId() {
        return id;
    }
}
