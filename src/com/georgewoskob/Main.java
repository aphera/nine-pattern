package com.georgewoskob;

public class Main {

    public static void main(String[] args) {
        int values[] = prettyPattern();
        for (int c = 0; c < values.length; c++) {
            System.out.println(c + ", " + values[c] + ";");
        }
    }

    private static int[] prettyPattern() {
        PatternGenerator patternGenerator1 = new PatternGenerator();
        int values[] = new int[1024];
        for (int c = 1; c <= 1; c++) {
            String pattern = patternGenerator1.play(1024);
            String splitValues[] = pattern.split(",");
            for (int i = 0; i < splitValues.length; i++) {
                values[i] += Integer.parseInt(splitValues[i]);
            }
        }
        PatternGenerator patternGenerator2 = new PatternGenerator(4);
        for (int c = 1; c <= 2; c++) {
            String pattern = patternGenerator2.play(256);
            String splitValues[] = pattern.split(",");
            for (int i = 0; i < splitValues.length; i++) {
                values[i] += Integer.parseInt(splitValues[i]);
            }
        }
        PatternGenerator patternGenerator3 = new PatternGenerator(16);
        for (int c = 1; c <= 4; c++) {
            String pattern = patternGenerator3.play(64);
            String splitValues[] = pattern.split(",");
            for (int i = 0; i < splitValues.length; i++) {
                values[i] += Integer.parseInt(splitValues[i]);
            }
        }
        PatternGenerator patternGenerator4 = new PatternGenerator(64);
        for (int c = 1; c <= 8; c++) {
            String pattern = patternGenerator4.play(16);
            String splitValues[] = pattern.split(",");
            for (int i = 0; i < splitValues.length; i++) {
                values[i] += Integer.parseInt(splitValues[i]);
            }
        }
        PatternGenerator patternGenerator5 = new PatternGenerator(256);
        for (int c = 1; c <= 16; c++) {
            String pattern = patternGenerator5.play(4);
            String splitValues[] = pattern.split(",");
            for (int i = 0; i < splitValues.length; i++) {
                values[i] += Integer.parseInt(splitValues[i]);
            }
        }
        return values;
    }
}
