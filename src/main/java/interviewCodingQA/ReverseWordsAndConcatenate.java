
/* TODO Java 8 Challenge: Reverse Each Word & Concatenate into a String! 🚀
Hey hashtag#JavaDevelopers! 👋
Let’s solve an interesting problem using Java Streams!
        🎯 Task: Given a list of words, reverse each word and concatenate them into a single string.

        🔹 Example:
Input: ["Java", "Streams", "Are", "Awesome"]
Output: "avaJ smaertS erA emosewA"

        💡 Java 8 Solution Using Streams:*/

package interviewCodingQA;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ReverseWordsAndConcatenate {

    public static void main(String [] args){

        List<String> words = Arrays.asList("Java","Streams","Are","Awesome");

        String result = words.stream()
                .map(word -> new StringBuilder(word).reverse().toString())  // .toUpperCase().toLowerCase()
                .collect(Collectors.joining(" "));
        System.out.println(result);

    }
// 👉 Can you achieve this without using StringBuilder?

    public static class ReverseAndConcatenatewithoutStringBuilder {
        public static void main(String[] args) {
            List<String> words = Arrays.asList("Java","Streams","Are","Awesome");

            String result = words.stream()
                    .map(word-> word.chars()// Convert word to an IntStream of char values   'J', 'a', 'v', 'a'.
                            .mapToObj(c -> String.valueOf((char)c))  // Map each int to a String representing the character ["J", "a", "v", "a"]
                            .reduce("", (a,b) -> b + a)  // reversing by prepending "avaJ"
                    )
                    .collect(Collectors.joining(" "));
            System.out.println(result);
        }
    }
}
/*

Let's break down the following code line by line to understand exactly how it reverses a word using Java Streams without using a StringBuilder:

java
        Copy
Edit
        .map(word ->
        word.chars()                                      // (1)
        .mapToObj(c -> String.valueOf((char)c))        // (2)
        .reduce("", (a, b) -> b + a)                     // (3)
        )
Detailed Explanation
word.chars()

What it does:
This method converts the given word (a String) into an IntStream. Each element in this stream represents the
Unicode code point (an int) of each character in the string.

Example:
For the word "Java", it produces an IntStream with elements corresponding to the characters 'J', 'a', 'v', 'a'.

        .mapToObj(c -> String.valueOf((char)c))

What it does:
The mapToObj method converts each integer (code point) in the IntStream to an object. Here, we convert each integer c
to its corresponding char, and then to a String.

Why necessary:
Working with objects (Strings) instead of primitive integers allows us to use the reduce method on a stream of strings.

Example:
The integer for 'J' becomes "J", for 'a' becomes "a", and so on. So, the stream now looks like: ["J", "a", "v", "a"].

        .reduce("", (a, b) -> b + a)

What it does:
The reduce method accumulates the elements of the stream into a single result. It starts with an initial
identity value ("", the empty string in this case) and then applies the binary operator (a, b) -> b + a to combine elements.

How it works (step-by-step for "Java"):

Initialization:
The accumulator is set to the identity value "".

First element ("J"):

The accumulator (a) is "" and the first element (b) is "J".

The operator computes b + a, which is "J" + "" resulting in "J".

Second element ("a"):

Now, a is "J" and b is "a".

The operator computes "a" + "J", resulting in "aJ".

Third element ("v"):

Now, a is "aJ" and b is "v".

The operator computes "v" + "aJ", resulting in "vaJ".

Fourth element ("a"):

Now, a is "vaJ" and b is "a".

The operator computes "a" + "vaJ", resulting in "avaJ".

Why it works:
Each new element is prepended to the accumulator. This causes the order of characters to be reversed relative to the original string.

Final Result:
The word "Java" becomes "avaJ".

Summary
Step 1: The word is broken down into its individual characters (as Unicode integers).

Step 2: These integers are converted into their character strings.

Step 3: The reduce operation then combines these strings by prepending each one to the accumulator, effectively reversing the order of the characters.

This functional approach replaces the typical mutable reversal process (like using StringBuilder) with a purely functional operation using streams.*/
