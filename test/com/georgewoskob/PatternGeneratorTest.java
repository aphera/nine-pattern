package com.georgewoskob;

import org.junit.Test;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PatternGeneratorTest {

    PatternGenerator patternGenerator;

    @Test
    public void shouldProduceNinePatterForFourInstances() {
        patternGenerator = new PatternGenerator("1", "0");
        List expectedPattern = newArrayList("1", "0", "0", "1");

        List actualPattern = patternGenerator.play(4);

        assertThat(actualPattern, is(expectedPattern));
    }

    @Test
    public void shouldProduceNinePatternForSixteenInstances() {
        patternGenerator = new PatternGenerator("1", "0");
        List expectedPattern = newArrayList("1", "0", "0", "1", "0", "1", "1", "0", "0", "1", "1", "0", "1", "0", "0", "1");

        List actualPattern = patternGenerator.play(16);

        assertThat(actualPattern, is(expectedPattern));
    }

    @Test
    public void shouldProduceNinePatternRepeatingEachInstanceFourTimes() {
        List expectedPattern = newArrayList("1", "1", "1", "1", "0", "0", "0", "0", "0", "0", "0", "0", "1", "1", "1", "1");

        patternGenerator = new PatternGenerator(4, "1", "0");

        List actualPattern = patternGenerator.play(4);

        assertThat(actualPattern, is(expectedPattern));
    }
}
