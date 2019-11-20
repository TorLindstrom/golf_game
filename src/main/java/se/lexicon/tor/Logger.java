package se.lexicon.tor;

import static java.lang.String.format;

public class Logger {
    private  int strokeLimit;
    private String[] completeLog;

    public Logger(int allowedStrokes){
        completeLog = new String[allowedStrokes];
    }

    public boolean logStroke(String hitDistance, String ballDistance, int strokeNum){
        try {
            completeLog[strokeNum - 1] = format("Stroke %2s:  You hit %14s, putting the ball %14s from the hole.", strokeNum, hitDistance, ballDistance);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    public void print(){
        System.out.println("Your results:");
        for (String stroke: completeLog){
            if (stroke == null) {
                break;
            }
            System.out.println(stroke);
        }
    }
}
