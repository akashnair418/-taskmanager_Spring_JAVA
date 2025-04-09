package interviewCodingQA;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ExtractNumbers {
    public static void main(String[] args) {
        String input = "The price is 100 dollars, and the discount is 20 percent.";

        // Extract numbers from the string using Java 8 Streams
        List<Integer> numbers = Arrays.stream(input.split("\\D+")) // Split the string by non-digit characters
                .filter(s -> !s.isEmpty()) // Remove empty results
                .map(Integer::parseInt) // Convert each element to an integer
                .collect(Collectors.toList()); // Collect the numbers into a list

        System.out.println("Extracted numbers: " + numbers);
    }
}
