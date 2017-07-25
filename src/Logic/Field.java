/*
 * Field.java
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

public class Field {
    private int width,height;
    private int zoneSize,zoneCount;
    private Zone[] rows,columns,squares;

//    private Vector<Zone> zones;
    private Cell[] cells;

    public Field(int width, int height) {
        this(new FieldDef(width,height,new int[width*height]));
    }

    public Field(FieldDef level) {
        width = level.width;
        height = level.height;
        zoneSize=Math.max(width, height);
        zoneCount=Math.min(width, height);
        createRows();
        createColumns();
        createSquares();
        createCells(level.values);
    }

    private void createCells(int[] values) {
        Vector<Zone> zones;
        Cell cell;
        cells=new Cell[width*height];
        int id,value;
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                id=x+y*width;
                zones=new Vector<>(3);
                zones.add(rows[y]);
                zones.add(columns[x]);
                zones.add(squares[(x/3)+(y/3)*3]);
                value=values[id];
                if (value>0){
                    cell=new Cell(id,true,value,zones);
                }
                else {
                    cell = new Cell(id,false, zoneSize, zones);
                }
                rows[y].addCell(x,cell);
                columns[x].addCell(y,cell);
                squares[(x/3)+(y/3)*3].addCell((x%3)+(y%3)*3,cell);
                cells[id]=cell;
            }

        }
    }

    private void createRows() {
        rows=new Zone[height];
        for (int i = 0; i < height; i++) {
            rows[i]=new Zone(width);
        }
    }

    private void createColumns() {
        columns=new Zone[width];
        for (int i = 0; i < width; i++) {
            columns[i]=new Zone(height);
        }
    }

    private void createSquares() {
        squares=new Zone[zoneSize];

        for (int i = 0; i < zoneCount; i++) {
            squares[i]=new Zone(zoneSize);
        }
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getZoneSize() {
        return zoneSize;
    }

    public int getCellValue(int id){
        Cell cell=getCellById(id);
        if(cell!=null)
            return cell.getValue();
        return 0;
    }

    public boolean[] getCellPencils(int id){
        Cell cell=getCellById(id);
        if(cell!=null)
            return cell.getPencil();
        return new boolean[zoneSize];
        }

    private Cell getCellById(int id){
        Cell result=null;
        for (Cell cell: cells) {
            if (cell.getId()==id){
                result=cell;
            }
        }
        return result;
    }
}
