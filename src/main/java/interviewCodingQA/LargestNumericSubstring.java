/*Find the Largest Numeric Substring in an Alphanumeric String Using Java 8! 🚀
        Hey connections! 👋 Today, let's tackle an interesting Java 8 challenge—extracting the largest numeric substring from an alphanumeric string.
        🛠 Problem Statement:
        Given an alphanumeric string, find the largest numeric substring (i.e., the number with the highest value).
        💡 Example:
        📌 Input: "abc123xyz98765pqr56"
        📌 Output: "98765" (largest numeric substring)*/

package interviewCodingQA;

import java.util.Comparator;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class LargestNumericSubstring {
    public static void main(String[] args) {

        String input = "abc123xyz98765pqr56";

        String largestNumber = Pattern.compile("\\D+")
                        .splitAsStream(input)
                                .filter(s-> !s.isEmpty())
                                        .max(Comparator.comparingLong(Long::parseLong))
                                                .orElse("");

        System.out.println("Largest Numeric Substring: " + largestNumber);
    }
}
