package interviewCodingQA;

import java.util.*;
import java.util.stream.Collectors;

public class PalindromeSubstrings {
    public static void main(String[] args) {
        String input = "madam and racecar are palindromes";

        // Find palindrome substrings
        List<String> palindromeSubstrings = getAllSubstrings(input)
                .stream()
                .filter(PalindromeSubstrings::isPalindrome) // Filter only palindromes
                .collect(Collectors.toList());

        System.out.println("Palindrome substrings: " + palindromeSubstrings);
    }

    // Method to get all substrings of a string
    public static List<String> getAllSubstrings(String str) {
        List<String> substrings = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j <= str.length(); j++) {
                substrings.add(str.substring(i, j));
            }
        }
        return substrings;
    }

    // Method to check if a string is palindrome
    public static boolean isPalindrome(String str) {
        String reversed = new StringBuilder(str).reverse().toString();
        return str.equals(reversed);
    }
}
/*

The above code snippet gives single-character substrings in the output.
To exclude single-character substrings (like "a", "m", etc.) from the palindrome output, use filter() before checking for palindromes.

.filter(s -> s.length() > 1) // Exclude single-character substrings*/
