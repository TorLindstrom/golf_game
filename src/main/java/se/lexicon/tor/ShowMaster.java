package se.lexicon.tor;

import java.util.Arrays;

public class ShowMaster {

    public final static int width = 160;

    public static void show(int distance) {
        int level;
        int maxForLevel = 0, minForLevel = 0;
        if (distance < 100){
            level = 1;
            maxForLevel = 100;
            minForLevel = 0;
        } else if (distance < 200){
            level = 2;
            maxForLevel = 200;
            minForLevel = 100;
        } else if (distance < 300){
            level = 3;
            maxForLevel = 300;
            minForLevel = 200;
        } else if (distance < 500){
            level = 4;
            maxForLevel = 500;
            minForLevel = 300;
        }else if (distance < 700){
            level = 5;
            maxForLevel = 700;
            minForLevel = 500;
        } else if (distance < 1000){
            level = 6;
            maxForLevel = 1000;
            minForLevel = 700;
        } else if (distance < 1500){
            level = 7;
            maxForLevel = 1500;
            minForLevel = 1000;
        } else if (distance < 2000){
            level = 8;
            maxForLevel = 2000;
            minForLevel = 1500;
        } else {
            level = 9;
            maxForLevel = 4000;
            minForLevel = 2000;
        }

        double percentageOfTheWay = ( ((double)distance - minForLevel) / (maxForLevel - minForLevel));
        int front = (int) (width * percentageOfTheWay);
        int back = width - front;

        String[] hole = new String[9];
        String[] ball = new String[9];
        String[] preRender = new String[9];
        switch (level) {
            case 1:
                hole = new String[]{
                        "  ||##       ",
                        "  ||#####    ",
                        "  ||#######  ",
                        "  ||         ",
                        "  ||         ",
                        "  ||         ",
                        "  ||         ",
                        "__||__   ____",
                        "      \\_/    "};
                ball = new String[]{
                        "             ",
                        "             ",
                        "             ",
                        "             ",
                        "             ",
                        "             ",
                        "             ",
                        "_____( )_____",
                        "             "};
                break;
            case 2:
                hole = new String[]{
                        "             ",
                        "  ||##       ",
                        "  ||####     ",
                        "  ||         ",
                        "  ||         ",
                        "  ||         ",
                        "  ||         ",
                        "__||__  _____",
                        "      \\/     "};
                ball = new String[]{
                        "             ",
                        "             ",
                        "             ",
                        "             ",
                        "             ",
                        "             ",
                        "             ",
                        "_____(#)_____",
                        "             "};
                break;
            case 3:
                hole = new String[]{
                        "             ",
                        "             ",
                        "  ||#        ",
                        "  ||##       ",
                        "  ||         ",
                        "  ||         ",
                        "  ||         ",
                        "__||__  _____",
                        "      \\/     "};
                ball = new String[]{
                        "             ",
                        "             ",
                        "             ",
                        "             ",
                        "             ",
                        "             ",
                        "             ",
                        "_____()______",
                        "             "};
                break;
            case 4:
                hole = new String[]{
                        "             ",
                        "             ",
                        "             ",
                        "  |#         ",
                        "  |##        ",
                        "  |          ",
                        "  |          ",
                        "__|__  ______",
                        "     \\/      "};
                ball = new String[]{
                        "             ",
                        "             ",
                        "             ",
                        "             ",
                        "             ",
                        "             ",
                        "             ",
                        "_____@_______",
                        "             "};
                break;
            case 5:
                hole = new String[]{
                        "             ",
                        "             ",
                        "             ",
                        "             ",
                        "  |##        ",
                        "  |          ",
                        "  |          ",
                        "__|__  ______",
                        "      \\/     "};
                ball = new String[]{
                        "             ",
                        "             ",
                        "             ",
                        "             ",
                        "             ",
                        "             ",
                        "             ",
                        "_____O_______",
                        "             "};
                break;
            case 6:
                hole = new String[]{
                        "             ",
                        "             ",
                        "             ",
                        "             ",
                        "             ",
                        "  |>         ",
                        "  |          ",
                        "__|_ ________",
                        "    V        "};
                ball = new String[]{
                        "             ",
                        "             ",
                        "             ",
                        "             ",
                        "             ",
                        "             ",
                        "             ",
                        "_____o_______",
                        "             "};
                break;
            case 7:
                hole = new String[]{
                        "             ",
                        "             ",
                        "             ",
                        "             ",
                        "             ",
                        "             ",
                        "  |>          ",
                        "__|_ ________",
                        "    v        "};
                ball = new String[]{
                        "             ",
                        "             ",
                        "             ",
                        "             ",
                        "             ",
                        "             ",
                        "             ",
                        "_____._______",
                        "             "};
                break;
            case 8:
                hole = new String[]{
                        "             ",
                        "             ",
                        "             ",
                        "             ",
                        "             ",
                        "             ",
                        "             ",
                        "__P__________",
                        "             "};
                ball = new String[]{
                        "             ",
                        "             ",
                        "             ",
                        "             ",
                        "             ",
                        "             ",
                        "             ",
                        "_____._______",
                        "             "};
                break;
            case 9:
                hole = new String[]{
                        "             ",
                        "             ",
                        "             ",
                        "             ",
                        "             ",
                        "             ",
                        "             ",
                        "__|__________",
                        "             "};
                ball = new String[]{
                        "             ",
                        "             ",
                        "             ",
                        "             ",
                        "             ",
                        "             ",
                        "             ",
                        "_____._______",
                        "             "};
                break;
            default:
        }
        for (int i = 0; i < 9; i++) {
            if (i != 7) {
                StringBuilder builder = new StringBuilder();
                preRender[i] = builder.append(fillerSpace(20)).append(hole[i]).append(fillerSpace(front)).append(ball[i]).append(fillerSpace(back)).toString();
            }
        }
        StringBuilder builder = new StringBuilder();
        preRender[7] = builder.append(fillerLawn(20)).append(hole[7]).append(fillerLawn(front)).append(ball[7]).append(fillerLawn(back)).toString();
        Cloud.showCloudScene();
        for (String line : preRender) {
            System.out.println(line);
        }
    }

    public static String fillerSpace(int length) {
        char[] fillerSpace = new char[length];
        Arrays.fill(fillerSpace, ' ');
        return new String(fillerSpace);
    }

    private static String fillerLawn(int length) {
        char[] fillerSpace = new char[length];
        Arrays.fill(fillerSpace, '_');
        return new String(fillerSpace);
    }

    private static void liner() {
        char[] liner = new char[width];
        Arrays.fill(liner, '=');
        liner[0] = '%';
        liner[width - 1] = '%';
        liner[1] = '}';
        liner[width - 2] = '{';
        System.out.println(new String(liner));
    }

}
