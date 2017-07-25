/*
 * PredefinedLevels.java
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

import java.util.ArrayList;

/**
 * Created by 212596044 on 7/24/2017.
 */
public class PredefinedLevels {
    FieldDef level=
    new FieldDef(9,9,new int[]
    {
        2,0,0,6,3,0,0,1,0,
        0,5,1,0,2,0,7,9,3,
        4,0,3,1,9,7,5,0,0,
        0,0,0,0,0,9,0,3,2,
        0,6,5,0,7,0,1,4,0,
        1,3,0,8,0,0,0,0,0,
        0,0,9,3,6,2,4,0,7,
        3,7,6,0,8,0,2,5,0,
        0,2,0,0,5,1,0,0,9,
    });
    public FieldDef getLevel(int levelNum){
        return level;
    }
}
