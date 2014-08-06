package com.georgewoskob;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

public class PatternGenerator {

    private int repeatsPerInstance = 1;
    private String on = "1";
    private String off = "-1";

    public PatternGenerator(int repeatsPerInstance, String on, String off) {
        this.repeatsPerInstance = repeatsPerInstance;
        this.on = on;
        this.off = off;
    }

    public PatternGenerator(String on, String off) {
        this.on = on;
        this.off = off;
    }

    public List play(int numberOfInstances) {
        boolean first = true;

        List beginningOfThePattern = newArrayList();
        return playAgain(numberOfInstances, first, beginningOfThePattern);
    }

    private List playAgain(int numberOfInstances, boolean first, List pattern) {
        if (numberOfInstances <= 4) {
            pattern = playBasePattern(numberOfInstances, first, pattern);
        } else {
            pattern = playAgain(numberOfInstances / 4, first, pattern);
            pattern = playAgain(numberOfInstances / 4, !first, pattern);
            pattern = playAgain(numberOfInstances / 4, !first, pattern);
            pattern = playAgain(numberOfInstances / 4, first, pattern);
        }
        return pattern;
    }

    private List playBasePattern(int numberOfInstances, boolean first, List pattern) {
        String outerString = first ? on : off;
        String innerString = first ? off : on;
        for (int c = 0; c < numberOfInstances; c++) {
            if (c == 0) {
                pattern = playInstant(outerString, pattern);
            } else if (c == 1) {
                pattern = playInstant(innerString, pattern);
            } else if (c == 2) {
                pattern = playInstant(innerString, pattern);
            } else {
                pattern = playInstant(outerString, pattern);
            }
        }
        return pattern;
    }

    private List playInstant(String unit, List pattern) {
        for(int c = 0; c < repeatsPerInstance; c++) {
            pattern.add(unit);
        }
        return pattern;
    }
}
