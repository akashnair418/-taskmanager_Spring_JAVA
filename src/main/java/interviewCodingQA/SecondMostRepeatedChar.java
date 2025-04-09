package interviewCodingQA;

import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SecondMostRepeatedChar {

    public static void main(String[] args) {
        String input = "Java Developer";

        Optional <Character> result = input.chars() //converting String to intStream char
                .mapToObj(c -> (char) c)  //Converts each integer back into a Character object,
                .filter(Character::isLetter) // filters non alphabet char
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .sorted((a,b) -> Long.compare(b.getValue(), a.getValue()))
                .skip(1)
                .map(Map.Entry::getKey)
                .findFirst();

        System.out.println(result);
    }
}

/*1. Converting the String into a Stream of Characters
java
        Copy
Edit
input.chars().mapToObj(c -> (char)c)
        input.chars()
This method converts the string "java developer" into an IntStream where each element represents the Unicode (integer) value of a character.

mapToObj(c -> (char)c)
This converts each integer value into its corresponding Character object. After this step, you have a stream of Character objects such as:
        ['j', 'a', 'v', 'a', ' ', 'd', 'e', 'v', 'e', 'l', 'o', 'p', 'e', 'r']

        2. Filtering Out Non-Letter Characters
java
        Copy
Edit
        .filter(Character::isLetter)
.filter(Character::isLetter)
This line filters the stream so that only letter characters are kept. It removes spaces (and any other non-letter symbols).
The resulting stream contains only letters:
        ['j', 'a', 'v', 'a', 'd', 'e', 'v', 'e', 'l', 'o', 'p', 'e', 'r']

        3. Grouping Characters and Counting Their Occurrences
java
        Copy
Edit
        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
Grouping:
The Collectors.groupingBy(Function.identity(), Collectors.counting()) operation collects elements of the stream into a Map where:

Key: The character itself.

        Value: The count of how many times that character appears in the stream.

Example:
For "java developer", the count might look like this:

        'a' → 3

        'e' → 3

        'v' → 2

        'j' → 1

        'd' → 1

        'l' → 1

        'o' → 1

        'p' → 1

        'r' → 1

Note: Depending on the input and whether you consider case sensitivity, the counts can differ; here our example is in lowercase due to our input.

        4. Sorting the Frequency Map Entries by Count
        java
Copy
        Edit
.entrySet().stream().sorted((a, b) -> Long.compare(b.getValue(), a.getValue()))
Converting to a Stream:
        The .entrySet().stream() takes the Map produced in step 3 and creates a stream of its entries, where each entry is a key-value pair (Map.Entry<Character, Long>).

Sorting:
        The .sorted((a, b) -> Long.compare(b.getValue(), a.getValue())) sorts the stream based on the count values in descending order.
This means the character with the highest frequency appears first.

Example Order:
After sorting, if 'e' has the highest frequency, it will be the first entry in the stream.

        5. Skipping the Most Repeated Character
        java
Copy
        Edit
.skip(1)
Purpose:
        The .skip(1) operation tells the stream to ignore the first entry in the sorted order. Since the first entry is the most repeated character, skipping it leaves the next entry, which will be the second most repeated character.

6. Extracting the Character from the Map Entry
        java
Copy
        Edit
.map(Map.Entry::getKey)
Mapping to Just the Character:
Now that you have the desired entry (the one representing the second most repeated character), .map(Map.Entry::getKey) extracts the key (the character) from that entry.

7. Finding the First (and Only) Result
java
        Copy
Edit
        .findFirst()
Finding the Second Most Repeated:
        The .findFirst() operation returns an Optional<Character> that contains the first element from the stream. Since you skipped the first element earlier, this element is the second most repeated character.

8. Printing the Result
        java
Copy
        Edit
result.ifPresent(System.out::println);
Output:
Finally, if the Optional contains a value, it's printed to the console. For the provided input, this would output:
        'a'*/
