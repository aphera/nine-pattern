package com.georgewoskob;

public class PatternGenerator {

    private int repeatsPerInstance = 1;
    private String on = "1";
    private String off = "-1";

    public PatternGenerator(int repeatsPerInstance) {
        this.repeatsPerInstance = repeatsPerInstance;
    }

    public PatternGenerator() {}

    public String play(int numberOfInstances) {
        boolean first = true;

        String beginningOfThePattern = "";
        return playAgain(numberOfInstances, first, beginningOfThePattern);
    }

    private String playAgain(int numberOfInstances, boolean first, String pattern) {
        if (numberOfInstances <= 4) {
            pattern = playBasePattern(numberOfInstances, first);
        } else {
            pattern += playAgain(numberOfInstances / 4, first, pattern) + playAgain(numberOfInstances / 4, !first, pattern) + playAgain(numberOfInstances / 4, !first, pattern) + playAgain(numberOfInstances / 4, first, pattern);
        }
        return pattern;
    }

    private String playBasePattern(int numberOfInstances, boolean first) {
        String pattern = "";
        for (int c = 0; c < numberOfInstances; c++) {
            String firstString = first ? on : off;
            String secondString = first ? off : on;
            if (c == 0) {
                pattern += playInstant(firstString);
            } else if (c == 1) {
                pattern += playInstant(secondString);
            } else if (c == 2) {
                pattern += playInstant(secondString);
            } else {
                pattern += playInstant(firstString);
            }
        }
        return pattern;
    }

    private String playInstant(String firstString) {
        String pattern = "";
        for(int c = 0; c < repeatsPerInstance; c++) {
            pattern += firstString + ",";
        }
        return pattern;
    }
}
