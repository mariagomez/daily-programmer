package com.mscandella.word_analytics;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordAnalytics {

    public int countNoOfWords(String text) {
        return text.split(" ").length;
    }

    public int countNoOfLetters(String text) {
        return text.replace(" ", "").length();
    }

    public int countNoOfSymbols(String text) {
        Pattern pattern = Pattern.compile("[^\\w\\s]");
        Matcher matcher = pattern.matcher(text);
        int counter = 0;
        while (matcher.find()) {
            counter++;
        }
        return counter;
    }

    public List<String> topThreeWords(String text) {
        WordCollection wordCollection = new WordCollection();

        for (String word : text.split(" ")) {
            wordCollection.add(word);
        }
        wordCollection.sort();

        return wordCollection.topThree();
    }

    public List<String> topThreeLetters(String text) {
        WordCollection wordCollection = new WordCollection();

        for (int index = 0; index < text.length(); index++) {
            String letter = String.valueOf(text.charAt(index));
            if (isALetter(letter)) wordCollection.add(letter);
        }
        wordCollection.sort();

        return wordCollection.topThree();
    }

    private boolean isALetter(String c) {
        Pattern pattern = Pattern.compile("[a-zA-Z]");
        Matcher matcher = pattern.matcher(c);
        return matcher.find();
    }
}
