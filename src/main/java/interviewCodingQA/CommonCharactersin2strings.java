/*Find Common Characters in Two Strings Using Java 8 Streams*/

        package interviewCodingQA;


import java.util.List;
import java.util.stream.Collectors;

public class CommonCharactersin2strings {

        public static void main(String[] args) {
            String str1 = "hello";
            String str2 = "world";

            // Find common characters between two strings
            List<Character> commonChars = str1.chars() // Convert the first string to a stream of chars
                    .mapToObj(c -> (char) c) // Convert each int to a Character
                    .filter(c -> str2.indexOf(c) != -1) // Check if the character exists in the second string
                    .distinct() // Remove duplicates
                    .collect(Collectors.toList()); // Collect the common characters into a list

            System.out.println("Common characters: " + commonChars);
        }
}
/*
.filter(c -> str2.indexOf(c) != -1)
This is a filter operation used in a Java Stream, and it's checking whether each character from str1 exists in str2.

        🔍 Let's go step-by-step:
        📌 1. What does .filter(...) do?
        .filter(...) is a stream operation that keeps only the elements that match a condition.

        📌 2. What is str2.indexOf(c)?
        String.indexOf(char) returns the index of the first occurrence of character c in the string.

If the character does not exist in the string, it returns -1.

        🧠 So what does this line mean?
java
        Copy
Edit
        .filter(c -> str2.indexOf(c) != -1)
This means:

        "Keep only those characters c from str1 that are also present in str2."

        ✅ Example:
Let's say:

java
        Copy
Edit
        str1 = "hello"
str2 = "world"
You stream over "hello": 'h', 'e', 'l', 'l', 'o'

        'h' → str2.indexOf('h') = -1 → ❌ not kept

'e' → str2.indexOf('e') = -1 → ❌ not kept

'l' → str2.indexOf('l') = 2 → ✅ kept

'o' → str2.indexOf('o') = 1 → ✅ kept*/
