package org.example;

import java.util.Arrays;

public final class TextAnalyzer {

    private TextAnalyzer() {
    }

    public static int wordCountMethod(String text) {
       /* String[] words = text.trim().split("\\s+");
        int wordCount = 0;
        for (String w : words) {
            if (!w.isEmpty()) {
                wordCount++;
            }
        }
        return wordCount;
        */
        return (int) Arrays.stream(text.trim().split("\\s+"))
                .filter(w->!w.isEmpty())
                .count();
    }

    public static int characterCountExcludingWhitespaceMethod(String text) {
       /* int nr = 0;
        for (int i = 0; i < text.length(); i++) {
            if (!Character.isWhitespace(text.charAt(i)))
                nr++;

        }
        return nr;

        */
        return (int)text.chars()
                .filter(ch->!Character.isWhitespace(ch))
                .count();
    }

    public static String longestWordMethod(String text) {
        /*String[] words = text.trim().split("\\s+");
        int max = 0;
        String maxW = null;
        for (String w : words) {
            if (w.length() > max) {
                max = w.length();
                maxW = w;
            }
        }
        return maxW;

         */
        return Arrays.stream(text.trim().split("\\s+"))
                .filter(w->!w.isEmpty())
                .reduce((a,b)->a.length()>=b.length()? a:b)
                .orElse(null);
    }

    public static double averageWordLengthMethod(String text) {
        /*String[] words = text.trim().split("\\s+");
        int sum = 0;
        int ct = 0;
        for (String w : words) {
            if (!w.isEmpty()) {
                sum += w.length();
                ct++;
            }
        }
        return ct == 0 ? 0.0 : (double) sum / ct;

         */
        return Arrays.stream(text.trim().split("\\s+"))
                .filter(w->!w.isEmpty())
                .mapToInt(String::length)
                .average()
                .orElse(0.0);
    }


    public static TextAnalysisResult analyze(String text) {
        if (text == null || text.isBlank())
            return new TextAnalysisResult(0, 0, null, 0.0);


        int wordCount = wordCountMethod(text);
        int characterCountExcludingWhitespace = characterCountExcludingWhitespaceMethod(text);
        String longestWord = longestWordMethod(text);
        double averageWordLength = averageWordLengthMethod(text);

        return new TextAnalysisResult(wordCount, characterCountExcludingWhitespace, longestWord, averageWordLength);
    }
}
