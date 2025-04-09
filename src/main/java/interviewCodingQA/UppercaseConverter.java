/*Java 8 Challenge: Convert a List of Strings to Uppercase Without Loops! 🚀
Hey hashtag#JavaDevelopers! 👋
Let's put Java 8 Streams to work and solve this without traditional loops! 💡
        🎯 Task: Given a list of strings, convert all elements to uppercase without using for or while loops.

🔹 Example:
Input: ["java", "streams", "lambda"]
Output: ["JAVA", "STREAMS", "LAMBDA"]*/

package interviewCodingQA;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UppercaseConverter {

    public static void main(String[] args) {

        List<String> words = Arrays.asList("java","is","awesome");

        List<String> result = words.stream()
                .map(String::toUpperCase)  //map(word -> word == null ? null : word.toUpperCase())  - hanlde null va;ues
                .collect(Collectors.toList());

        System.out.println(result);
    }
}
