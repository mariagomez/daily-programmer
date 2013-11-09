package com.mscandella.word_analytics;

import java.util.*;

public class WordCollection {
    private List<Word> words = new ArrayList<Word>();

    public void add(String word) {
        if (!contains(word))
            words.add(new Word(word));
        else
            updateWordOccurrencyCount(word);
    }

    public void sort() {
        Collections.sort(words, new WordOccurrencesComparator());

    }

    private void updateWordOccurrencyCount(String word) {
        words.set(indexOfWord(word), new Word(word, words.get(indexOfWord(word)).getCount() + 1)) ;
    }

    private boolean contains(String word) {
        return indexOfWord(word) >= 0;
    }

    private int indexOfWord(String word) {
        for (int index = 0; index < words.size(); index++) {
            if (words.get(index).getWord().equals(word)) return index;
        }
        return -1;
    }

    public List<String> topThree() {
        return Arrays.asList(words.get(0).getWord(), words.get(1).getWord(), words.get(2).getWord());
    }

    private class WordOccurrencesComparator implements Comparator<Word> {
        @Override
        public int compare(Word word, Word word2) {
            return word.compareTo(word2);
        }
    }
}
