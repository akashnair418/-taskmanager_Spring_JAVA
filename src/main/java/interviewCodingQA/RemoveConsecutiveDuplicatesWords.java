/*Remove Consecutive Duplicate Words in a Sentence!
        Hey LinkedIn Fam! 👋
        Here’s a cool way to remove consecutive duplicate words from a sentence using Java 8. Check out this clean one-liner using Streams and Regular Expressions!

        🔹 Problem Statement:
        Given a sentence, remove consecutive duplicate words while keeping the order intact.*/

package interviewCodingQA;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@Slf4j
public class RemoveConsecutiveDuplicatesWords {

    public static void main(String[] args) {

        String sentence = "java java is is heavy heavy language";

        String result = Arrays.stream(sentence.split("\\s+"))
                .reduce((a,b)-> a.endsWith(b) ? a : a + " " + b)
                .orElse("");
        System.out.println(result);

    }
}

/*Using .reduce(...)


        .reduce((a, b) -> a.endsWith(b) ? a : a + " " + b)
This is a binary reduction of the stream using a lambda (a, b).

a → the accumulator so far.

b → the next word in the stream.

        ✅ Logic:

a.endsWith(b) ? a : a + " " + b
If the accumulator (a) already ends with the word b, then skip it (avoid duplication).

Else, append b to a with a space.

✅ Example: Let's simulate how it works with your sentence:

a = "Java"
b = "Java" → a.endsWith("Java") = true → keep `a`
a = "Java"
b = "is" → a.endsWith("is") = false → a = "Java is"
a = "Java is"
b = "is" → a.endsWith("is") = true → skip
        a = "Java is"
b = "awesome" → append
...
Eventually:

"Java is awesome Java"
        Using .orElse("")

In case the stream is empty, it provides a default value: an empty string ("").*/
