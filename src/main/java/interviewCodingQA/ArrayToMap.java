/*🛠 Problem Statement:
        Given an array of words, create a Map<String, Integer>, where:
        🔹 The key is the word.
        🔹 The value is the length of the word.
        💡 Example:
        📌 Input: ["Java", "Streams", "Map", "Example"]
        📌 Output: {Java=4, Streams=7, Map=3, Example=7}

        https://www.linkedin.com/in/kamala-samraj-augustin-58607513a/recent-activity/all/
        */


package interviewCodingQA;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class ArrayToMap {
    public static void main(String[] args) {
        String[] words = {"Java", "Python","XML"};

        Map<String, Integer> result = Arrays.stream(words)
                .collect(Collectors.toMap(word-> word,String::length));
        System.out.println(result);
    }
}
