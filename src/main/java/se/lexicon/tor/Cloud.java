package se.lexicon.tor;

import java.util.Random;

public class Cloud {
    private static StringBuilder[] cloudScene;
    static Random random = new Random();

    private String[] cloud;

    public Cloud(){
        switch (random.nextInt(4)+1){
            case 1:
                cloud = new String[]{
                        "                       ",
                        "                       ",
                        "                       ",
                        "              ______   ",
                        "         ____/      \\  ",
                        "   _____/     \\      \\ ",
                        " /      \\     /   ___/ ",
                        "|          _          \\",
                        "\\_______/_\\___________/",
                        "                       "
                };
                break;
            case 2:
                cloud = new String[]{
                        "                       ",
                        "           _______     ",
                        "     _____/        \\   ",
                        "    /  ___/ \\ ____  \\  ",
                        "   | /    \\   /     \\| ",
                        "   \\_____/_________/   ",
                        "                       ",
                        "                       ",
                        "                       ",
                        "                       "
                };
                break;
            case 3:
                cloud = new String[]{
                        "                       ",
                        "               ____    ",
                        "              / \\  \\   ",
                        "       ___   \\______/  ",
                        "    __/   \\__          ",
                        "  /  \\       \\         ",
                        "  \\_________/          ",
                        "                       ",
                        "                       ",
                        "                       "
                };
                break;
            case 4:
                cloud = new String[]{
                        "             ___       ",
                        "           /    \\_     ",
                        "       ____\\      \\    ",
                        "      /   \\ _____/     ",
                        "      \\  /      \\      ",
                        "    __/  \\___   |      ",
                        "   /  \\__/    \\/__     ",
                        "  |            |   \\   ",
                        "  \\___________/___/    ",
                        "                       "
                };
                break;
            default:
                System.out.println("Error");
        }
    }

    public static void makeClouds(){
        StringBuilder[] preRender = new StringBuilder[10];
        for (int i = 0; i < preRender.length; i++){
            preRender[i] = new StringBuilder();
        }
        int amountOfClouds = random.nextInt(7);
        int availableSpace = ShowMaster.width - (amountOfClouds * 23);
        for (int i = 0; i < amountOfClouds; i++){
            Cloud cloud = new Cloud();
            int randomPadLength = random.nextInt(availableSpace);
            availableSpace -= randomPadLength;
            for (int j = 0; j < 10; j++) {
                preRender[j].append(ShowMaster.fillerSpace(randomPadLength)).append(cloud.cloud[j]);
            }
        }
        for (int i = 0; i < 10; i++){
            preRender[i].append(ShowMaster.fillerSpace(availableSpace));
        }
        cloudScene = preRender;
    }

    public static void showCloudScene(){
        for (StringBuilder builder: cloudScene){
            System.out.println(builder.toString());
        }
    }
}
