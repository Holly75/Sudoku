package Logic;

import java.util.Vector;

public class Cell {
    private int id;
    private boolean locked, filled;
    private int value, maxvalue;
    private boolean[] pencil;
    private Vector<Zone> zones;

    Cell(int id, boolean locked, int value, Vector<Zone> zones) {
        this.id = id;
        this.locked = locked;
        this.zones = zones;
        if (locked) {
            this.value = value;
        } else {
            this.maxvalue = value;
            reset();
        }

    }

    void reset() {
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

    int getValue() {
        return value;
    }

    public void setValue(int value) {
        if (!locked)
            this.value = value;
    }

    public int getMaxvalue() {
        return maxvalue;
    }

    boolean[] getPencil() {
        return pencil;
    }

    public Vector<Zone> getZones() {
        return zones;
    }

    int getId() {
        return id;
    }
}
