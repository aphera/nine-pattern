package com.georgewoskob;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

public class Main {

    private static List prettyPattern() {
        List<Integer> waveform = newArrayList();
        for (int c = 0; c < 4096; c++) {
            waveform.add(0);
        }
        waveform = addToWaveform(waveform, 1, 4096, 16);
        waveform = addToWaveform(waveform, 4, 1024, 19);
        waveform = addToWaveform(waveform, 16, 256, 25);
        waveform = addToWaveform(waveform, 64, 64, 29);
        waveform = addToWaveform(waveform, 256, 16, 31);
        waveform = addToWaveform(waveform, 1024, 4, 32);
        return waveform;
    }

    private static List addToWaveform(List<Integer> waveform, int repeatsPerInstance, int numberOfInstances, int weight) {
        PatternGenerator patternGenerator = new PatternGenerator(repeatsPerInstance, "1", "-1");
        for (int c = 0; c < weight; c++) {
            List<String> pattern = patternGenerator.play(numberOfInstances);
            for (int i = 0; i < pattern.size(); i++) {
                waveform.set(i, waveform.get(i) + Integer.parseInt(pattern.get(i)));
            }
        }
        return waveform;
    }

    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        List waveform = prettyPattern();
        PrintWriter writer = new PrintWriter("newWaveform.txt", "UTF-8");
        for (int c = 0; c < waveform.size(); c++) {
            writer.println(c + ", " + waveform.get(c) + ";");
        }
        writer.close();
    }
}
