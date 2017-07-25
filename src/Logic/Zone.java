package Logic;

class Zone {
    private int size;
    private Cell[] cells;

    Zone(int size) {
        this.size = size;
        cells = new Cell[size];
    }

    void addCell(int number, Cell cell) {
        cells[number] = cell;
    }

}
