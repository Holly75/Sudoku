package Logic;

import java.util.Vector;

public class Cell {
    private int id;
    private boolean locked, filled;
    private int value;
    private static int maxvalue;
    private boolean[] pencil;
    private Vector<Zone> zones;

    Cell(int id, boolean locked, int value, Vector<Zone> zones) {
        this.id = id;
        this.locked = locked;
        this.zones = zones;
        if (locked) {
            this.value = value;

        } else {
            maxvalue = value;
            reset();
        }

    }

    private void reset() {
        pencil = new boolean[maxvalue];
        value = 0;
        filled = false;

    }

    public boolean isLocked() {
        return locked;
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
        if (!locked)
            this.value = value;
    }

    public int getMaxvalue() {
        return maxvalue;
    }

    boolean[] getPencils() {
        return pencil;
    }
    boolean getPencil(int id){
        return pencil[id];
    }

    boolean setPencil(int id,boolean value){
        boolean result=pencil[id];
        pencil[id]=value;
        return result;
    }



    public Vector<Zone> getZones() {
        return zones;
    }

    int getId() {
        return id;
    }
}
