/*Convert a String into a Character Frequency Map Using Java 8! 🚀
        Hey connections! 👋 Today, let's explore a Java 8 Streams trick—counting character frequencies in a string and storing them in a Map!

        🛠 Problem Statement:
        Given a string, generate a Map<Character, Integer>, where:
        🔹 The key is a character.
        🔹 The value is the number of times the character appears.
        💡 Example:
        📌 Input: "java8streams"
        📌 Output: {a=2, e=1, j=1, m=1, r=1, s=2, t=1, v=1, 8=1}*/

package interviewCodingQA;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CharFrequencyMap {

    public static void main(String[] args) {

        String word = "java8Streams with 23 rd Akash NAir";

        Map<Character, Long> frequenyMap = word.chars()
                .mapToObj(c -> (char) c)
                .filter(Character::isLetter)
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        System.out.println(frequenyMap);
    }
}
