package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class TextAnalyzerTest {

    @Test
    void analyze_simpleSentence() {
        String text = "Hello world this is Java";
        TextAnalysisResult result = TextAnalyzer.analyze(text);

        assertEquals(5, result.getWordCount());
        // "Hello world this is Java"
        // No whitespace count:
        // "Hello" (5) + "world" (5) + "this" (4) + "is" (2) + "Java" (4) = 20
        assertEquals(20, result.getCharacterCountExcludingWhitespace());
        assertEquals("Hello", result.getLongestWord());
        assertEquals(20.0 / 5.0, result.getAverageWordLength(), 0.0001);
    }

    @Test
    void analyze_withPunctuationAndExtraSpaces() {
        String text = "Hello,   world!  This is   Java.";
        TextAnalysisResult result = TextAnalyzer.analyze(text);

        // Words: ["Hello,", "world!", "This", "is", "Java."]
        assertEquals(5, result.getWordCount());

        // Character count excl. whitespace:
        // H e l l o ,   w o r l d !   T h i s   i s   J a v a .
        // Count manually (excluding spaces):
        // "Hello," (6) + "world!" (6) + "This" (4) + "is" (2) + "Java." (5) = 23
        assertEquals(23, result.getCharacterCountExcludingWhitespace());

        // Longest words: "Hello," (6), "world!" (6), "Java." (5)
        // First longest should be "Hello,"
        assertEquals("Hello,", result.getLongestWord());

        assertEquals(23.0 / 5.0, result.getAverageWordLength(), 0.0001);
    }

    @Test
    void analyze_nullInput() {
        TextAnalysisResult result = TextAnalyzer.analyze(null);

        assertEquals(0, result.getWordCount());
        assertEquals(0, result.getCharacterCountExcludingWhitespace());
        assertNull(result.getLongestWord());
        assertEquals(0.0, result.getAverageWordLength(), 0.0001);
    }

    @Test
    void analyze_emptyString() {
        TextAnalysisResult result = TextAnalyzer.analyze("");

        assertEquals(0, result.getWordCount());
        assertEquals(0, result.getCharacterCountExcludingWhitespace());
        assertNull(result.getLongestWord());
        assertEquals(0.0, result.getAverageWordLength(), 0.0001);
    }

    @Test
    void analyze_whitespaceOnly() {
        TextAnalysisResult result = TextAnalyzer.analyze("   \n\t   ");

        assertEquals(0, result.getWordCount());
        assertEquals(0, result.getCharacterCountExcludingWhitespace());
        assertNull(result.getLongestWord());
        assertEquals(0.0, result.getAverageWordLength(), 0.0001);
    }

    @Test
    void analyze_singleWord() {
        TextAnalysisResult result = TextAnalyzer.analyze("One");

        assertEquals(1, result.getWordCount());
        assertEquals(3, result.getCharacterCountExcludingWhitespace());
        assertEquals("One", result.getLongestWord());
        assertEquals(3.0, result.getAverageWordLength(), 0.0001);
    }

    @Test
    void analyze_longestWordTieChoosesFirst() {
        String text = "aa   bbb cc ddd";
        TextAnalysisResult result = TextAnalyzer.analyze(text);

        // Words: ["aa", "bbb", "cc", "ddd"]
        assertEquals(4, result.getWordCount());
        // Character count (no spaces): 2 + 3 + 2 + 3 = 10
        assertEquals(10, result.getCharacterCountExcludingWhitespace());

        // "bbb" and "ddd" both length 3; first should be "bbb"
        assertEquals("bbb", result.getLongestWord());

        assertEquals(10.0 / 4.0, result.getAverageWordLength(), 0.0001);
    }
}
