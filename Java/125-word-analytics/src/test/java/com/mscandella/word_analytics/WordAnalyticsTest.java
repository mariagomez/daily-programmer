package com.mscandella.word_analytics;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class WordAnalyticsTest {

    private WordAnalytics wordAnalytics;

    @Before
    public void setUp() throws Exception {
        wordAnalytics = new WordAnalytics();
    }

    @Test
    public void shouldCountNumberOfWords() {
        String inputTextWithTwoWords = "Lorem Ipsum";
        int expectedWordNo = 2;

        int actualWordNo = wordAnalytics.countNoOfWords(inputTextWithTwoWords);

        assertThat(actualWordNo, is(expectedWordNo));
    }

    @Test
    public void shouldCountNumberOfLetters() {
        String inputTextWithTenLetters = "Lorem Ipsum";
        int expectedLetterNo = 10;

        int actualLetterNo = wordAnalytics.countNoOfLetters(inputTextWithTenLetters);

        assertThat(actualLetterNo, is(expectedLetterNo));
    }

    @Test
    public void shouldCountNumberOfSymbols() {
        String inputTextWithThreeSymbols = "$%asd^ fgt34";
        int expectedNoOfSymbols = 3;

        int actualNoOfSymbols = wordAnalytics.countNoOfSymbols(inputTextWithThreeSymbols);

        assertThat(actualNoOfSymbols, is(expectedNoOfSymbols));
    }

    @Test
    public void shouldReturnTheThreeMostCommonWords() {
        String inputText = "hello bye one two hello three four five six bye seven eight nine ten one two hello";
        List<String> expectedTopThree = Arrays.asList("hello", "bye", "one");

        List<String> actualTopThree = wordAnalytics.topThreeWords(inputText);

        assertThat(actualTopThree.containsAll(expectedTopThree), is(true));
    }

    @Test
    public void shouldReturnTheThreeMostCommonLetters() {
        String inputText = "one two three four five six seven eight nine ten";
        List<String> expectedTopThree = Arrays.asList("e", "n", "t");

        List<String> actualTopThree = wordAnalytics.topThreeLetters(inputText);

        assertThat(actualTopThree.containsAll(expectedTopThree), is(true));
    }
}
