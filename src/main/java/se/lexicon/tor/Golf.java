package se.lexicon.tor;

import java.util.Scanner;

public class Golf {

    public static Scanner scanner = new Scanner(System.in);

    public static void run() {
        while (true) {
            Logger logger = playHole();
            logger.print();
            if (!askForContinue()){
                break;
            }
        }
    }

    public static Logger playHole(){
        Cloud.makeClouds();
        Ball ball = new Ball();
        int distance = ball.getPos();
        int par = distance / 2000 + 1;
        int strokeLimit = par * 2;
        int strokeNum = 0;
        boolean win = true;
        Logger logger = new Logger(strokeLimit);
        System.out.println("The distance from the hole is " + inMeters(distance) + ", par is at " + par + " strokes, and the hole's stroke limit is " + strokeLimit);
        ShowMaster.show(distance / 10);
        while (distance > 1) {
            if (strokeNum == strokeLimit){
                win = false;
                break;
            }
            ++strokeNum;
            int hitDistance = calculateDistance(askAngle(), askVelocity());
            distance = Math.abs(distance - hitDistance);
            ShowMaster.show(distance / 10);
            logger.logStroke(inMeters(hitDistance), inMeters(distance), strokeNum);
            System.out.println("You hit it:\t" + inMeters(hitDistance) + ", and you are\t" + inMeters(distance) + ", away from the hole.");
        }
        if (win) {
            String bird;
            int fromPar = par - strokeNum;
            switch (fromPar){
                case 1:
                    bird = "and a Birdie on top of that!";
                    break;
                case 2:
                    bird = "and an Eagle on top of that!";
                    break;
                case 3:
                    bird = "Hooboy, an Albatross, that is incredible!";
                    break;
                case 4:
                    bird = "Oh, lordie, that was a Condor, only a few have ever been recorded!";
                    break;
                default:
                    bird = "Good job!";
            }
            System.out.println("You got it in!  " + bird);
        } else {
            System.out.println("You reached the stroke limit, too bad...");
        }
        return logger;
    }

    public static int askAngle() {
        while (true) {
            try {
                System.out.print("Please enter your hitting angle:\t");
                int angle = Integer.parseInt(scanner.nextLine());
                if (angle > 0 && angle < 90){
                    return angle;
                }
            } catch (Exception ignored) { }
            System.out.println("You did not enter a valid angle, it must be within 1 to 89 degrees.");
        }
    }

    public static int askVelocity() {
        while (true) {
            try {
                System.out.print("Please enter your hitting velocity:\t");
                int velocity = Integer.parseInt(scanner.nextLine());
                if (velocity > 0 && velocity < 101){
                    return velocity;
                }
            } catch (Exception e) { }
            System.out.println("You did not enter a valid velocity, it must be less within 1 to 100 meters per second.");
        }
    }

    public static boolean askForContinue() {
        while (true) {
            System.out.println("Want to play more golf? (y/n)");
            switch (scanner.nextLine().toLowerCase()) {
                case "y":
                    System.out.println("Oh, that's nice, let's go then!");
                    return true;
                case "n":
                    System.out.println("Okay then, byebye");
                    return false;
                default:
                    System.out.println("\nEnter either \"y\" or \"n\"\n");
            }
        }
    }

    public static String inMeters(int distance) {
        StringBuilder meters = new StringBuilder(String.valueOf(distance));
        meters.insert(meters.length() - 1, '.').append(" meters");
        return meters.toString();
    }

    public static int calculateDistance(int angle, int velocity) {
        double radians = (Math.PI / 180) * angle;
        return (int) (Math.pow(velocity, 2) / 9.82 * Math.sin(2 * radians) * 10);
    }
}


