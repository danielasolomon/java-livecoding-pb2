package org.example;

public class Main {

    public static void main(String[] args) {
        String text = "Hello,   world!  This is   Java.";
        TextAnalysisResult result = TextAnalyzer.analyze(text);

        System.out.println("Input text: " + text);
        System.out.println("Word count: " + result.getWordCount());
        System.out.println("Character count (no whitespace): "
                + result.getCharacterCountExcludingWhitespace());
        System.out.println("Longest word: " + result.getLongestWord());
        System.out.println("Average word length: " + result.getAverageWordLength());
    }
}
