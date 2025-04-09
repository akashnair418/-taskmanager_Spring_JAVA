/*Problem Statement:
        Given a comma-separated string, convert it into a List of strings efficiently using Java 8.
        💡 Example:
        📌 Input: "apple,banana,grape,orange"
        📌 Output: ["apple", "banana", "grape", "orange"]*/

package interviewCodingQA;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CSVToList {

    public static void main(String[] args) {
        String csv = "apple,banana,grape,orange";

        List<String> list = Arrays.stream(csv.split(","))
                .map(String::trim) // Remove any extra spaces
                .collect(Collectors.toList());

        System.out.println(list); // Output: [apple, banana, grape, orange]
    }
}
