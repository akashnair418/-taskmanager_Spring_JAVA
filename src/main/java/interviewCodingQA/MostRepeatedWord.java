package interviewCodingQA;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MostRepeatedWord {
    public static void main(String[] args) {
        String paragraph = "Java is great, and Java streams are powerful. Java can handle big data.";

        // Find the most repeated word
        String mostRepeatedWord = Arrays.stream(paragraph.split("\\W+"))
                .map(String::toLowerCase) // Convert to lowercase for case-insensitivity
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting())) // Count occurrences
                .entrySet()
                .stream()
                .max(Comparator.comparingLong(Map.Entry::getValue)) // Get the word with the highest count
                .map(Map.Entry::getKey)
                .orElse(null);

        System.out.println("Most repeated word: " + mostRepeatedWord);
    }
}
/*
How It Works:
        🔹 Splits the paragraph into words using split("\\W+").
        🔹 Maps words to lowercase to handle case insensitivity.
 🔹 Groups and counts word occurrences with Collectors.groupingBy() and Collectors.counting().
        🔹 Finds the most repeated word by comparing counts using .max().

Example Output:
Most repeated word: java*/
