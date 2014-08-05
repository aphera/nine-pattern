package com.georgewoskob;

public class Main {

    public static void main(String[] args) {
        prettyPattern();
    }

    private static void prettyPattern() {
        PatternGenerator patternGenerator1 = new PatternGenerator();
        int repeats = 8;
        for (int c = 1; c <= repeats; c++) {
            System.out.println(patternGenerator1.play(256));
        }
        PatternGenerator patternGenerator2 = new PatternGenerator(4);
        for (int c = 1; c <= repeats; c++) {
            System.out.println(patternGenerator2.play(64));
        }
        PatternGenerator patternGenerator3 = new PatternGenerator(16);
        for (int c = 1; c <= repeats; c++) {
            System.out.println(patternGenerator3.play(16));
        }
        PatternGenerator patternGenerator4 = new PatternGenerator(64);
        for (int c = 1; c <= repeats; c++) {
            System.out.println(patternGenerator4.play(4));
        }
    }
}
