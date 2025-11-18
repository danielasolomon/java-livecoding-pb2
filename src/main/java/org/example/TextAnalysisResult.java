package org.example;

public class TextAnalysisResult {

    private final int wordCount;
    private final int characterCountExcludingWhitespace;
    private final String longestWord;
    private final double averageWordLength;

    public TextAnalysisResult(int wordCount,
                              int characterCountExcludingWhitespace,
                              String longestWord,
                              double averageWordLength) {
        this.wordCount = wordCount;
        this.characterCountExcludingWhitespace = characterCountExcludingWhitespace;
        this.longestWord = longestWord;
        this.averageWordLength = averageWordLength;
    }

    public int getWordCount() {
        return wordCount;
    }

    public int getCharacterCountExcludingWhitespace() {
        return characterCountExcludingWhitespace;
    }

    public String getLongestWord() {
        return longestWord;
    }

    public double getAverageWordLength() {
        return averageWordLength;
    }

    @Override
    public String toString() {
        return "TextAnalysisResult{" +
                "wordCount=" + wordCount +
                ", characterCountExcludingWhitespace=" + characterCountExcludingWhitespace +
                ", longestWord='" + longestWord + '\'' +
                ", averageWordLength=" + averageWordLength +
                '}';
    }
}
