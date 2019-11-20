package se.lexicon.tor;

import java.util.Random;

public class Ball {
    private int pos;
    private int startDistance;
    private static Random placer = new Random();

    public Ball(){
        startDistance = place(2000, 30000);
        pos = startDistance;
    }

    public static int place(int from, int to){
        return placer.nextInt(to - from) + from;
    }

    public int getPos() {
        return Math.abs(pos);
    }

    public String getMeters(){
        StringBuilder meters = new StringBuilder(String.valueOf(Math.abs(pos)));
        meters.insert(meters.length()-2, '.').append(" meters");
        return meters.toString();
    }
}
