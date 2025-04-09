package interviewCodingQA;

import java.util.stream.Collectors;

public class RemoveSpecialCharacters {
    public static void main(String[] args) {
        String input = "Hello! @Java$ 8 Str#eams@2021.";

        // Remove special characters using Java 8 Streams
        String cleanedString = input.chars()
                .filter(c -> Character.isLetterOrDigit(c) || Character.isWhitespace(c)) // Retain only letters, digits, and whitespaces
                .mapToObj(c -> String.valueOf((char) c))
                .collect(Collectors.joining()); // Join characters back to a string

        System.out.println("Cleaned string: " + cleanedString);
    }
}

// if want to retain any one of these special char use
// | c == '@'