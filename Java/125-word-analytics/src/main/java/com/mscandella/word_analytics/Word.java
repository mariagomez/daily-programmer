package com.mscandella.word_analytics;

public class Word implements Comparable<Word> {
    private int count;
    private String word;

    public Word(String word) {
        this(word, 1);
    }

    public Word(String word, int count) {
        this.word = word;
        this.count = count;
    }

    public String getWord() {
        return word;
    }

    public int getCount() {
        return count;
    }

    @Override
    public int compareTo(Word other) {
        if (this.count > other.count) return -1;
        else if (this.count < other.count) return 1;
        return 0;
    }
}
