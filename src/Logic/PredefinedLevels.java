package Logic;

public class PredefinedLevels {
    private FieldDef level =
            new FieldDef(9, 9, new int[]
                    {
                            2, 0, 0, 6, 3, 0, 0, 1, 0,
                            0, 5, 1, 0, 2, 0, 7, 9, 3,
                            4, 0, 3, 1, 9, 7, 5, 0, 0,
                            0, 0, 0, 0, 0, 9, 0, 3, 2,
                            0, 6, 5, 0, 7, 0, 1, 4, 0,
                            1, 3, 0, 8, 0, 0, 0, 0, 0,
                            0, 0, 9, 3, 6, 2, 4, 0, 7,
                            3, 7, 6, 0, 8, 0, 2, 5, 0,
                            0, 2, 0, 0, 5, 1, 0, 0, 9,
                    });

    public FieldDef getLevel(int levelNum) {
        return level;
    }
}
