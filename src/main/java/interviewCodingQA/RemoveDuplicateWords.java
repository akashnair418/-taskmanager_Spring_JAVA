/*Java 8 Challenge: Remove Duplicate Words from a String! 🚀
        Hey hashtag#JavaDevelopers! 👋
        Let’s solve a common text-processing problem using Java 8 Streams!
        🎯 Task: Given a string, identify and remove duplicate words while maintaining the original order.

        🔹 Example:
        Input: "Java is awesome and Java is powerful"
        Output: "Java is awesome and powerful"*/

package interviewCodingQA;

import java.util.Arrays;
import java.util.stream.Collectors;

public class RemoveDuplicateWords {

    public static void main(String[] args){

        String input = "Java is awesome !! and Java is Powerfull !!";

        String result = Arrays.stream(input.split("\\s+", 0))
                .distinct()
                .collect(Collectors.joining(" "));

        System.out.println(result);
    }
}

/*How it works:

The regex "\\s+" matches one or more whitespace characters.

For the string "Java is awesome and Java is Powerfull", it produces an array:

["Java", "is", "awesome", "and", "Java", "is", "Powerfull"]
Internal Detail:
The split method traverses the entire input string, locating sequences of whitespace, and divides the string at those points.

Arrays.stream(...)
Purpose:
Converts the array resulting from the split operation into a Stream of strings.

How it works:

The stream API allows you to perform operations on sequences of data.

Now, the stream contains the elements:

"Java", "is", "awesome", "and", "Java", "is", "Powerfull"*/
