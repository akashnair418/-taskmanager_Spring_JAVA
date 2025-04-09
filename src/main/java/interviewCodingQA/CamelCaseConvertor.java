package interviewCodingQA;

import java.util.Arrays;
import java.util.stream.Collectors;

public class CamelCaseConvertor {

    public static void main(String[] args) {

        String input ="java 8 streams are powerful";

        String result = Arrays.stream(input.split("\\s+"))
                .map(word -> Character.toUpperCase(word.charAt(0))
                + word.substring(1).toLowerCase())
                .collect(Collectors.joining());
        System.out.println(result);
    }
}


/*
Step 1: sentence.split("\\s+")
Splits the string into words wherever there's one or more spaces.

java
        Copy
Edit
["java", "8", "streams", "are", "powerful"]
Step 2: .map(word -> ...)
For each word, the lambda:

java
        Copy
Edit
Character.toUpperCase(word.charAt(0)) + word.substring(1).toLowerCase()
performs:

        word.charAt(0) → Get the first character of the word.

        Character.toUpperCase(...) → Capitalize it.

        word.substring(1).toLowerCase() → Get the rest of the word, and make it lowercase.

Concatenate both to get a capitalized word.

        Examples:

        "java" → "J" + "ava" → "Java"

        "streams" → "S" + "treams" → "Streams"

        "8" → stays "8" (non-letter char is fine)

        "powerful" → "Powerful"

*/
