package com.georgewoskob;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PatternGeneratorTest {

    PatternGenerator patternGenerator = new PatternGenerator();

    @Test
    public void shouldProduceNinePatterForFourInstances() {
        String expectedPattern = "1001";

        String actualPattern = patternGenerator.play(4);

        assertThat(actualPattern, is(expectedPattern));
    }

    @Test
    public void shouldProduceNinePatternForSixteenInstances() {
        String expectedPattern = "1001011001101001";

        String actualPattern = patternGenerator.play(16);

        assertThat(actualPattern, is(expectedPattern));
    }

    @Test
    public void shouldProduceNinePatternRepeatingEachInstanceFourTimes() {
        String expectedPattern = "1111000000001111";

        patternGenerator = new PatternGenerator(4);

        String actualPattern = patternGenerator.play(4);

        assertThat(actualPattern, is(expectedPattern));
    }
}
