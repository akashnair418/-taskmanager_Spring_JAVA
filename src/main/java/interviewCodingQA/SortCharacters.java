package interviewCodingQA;

import java.util.Comparator;
import java.util.stream.Collectors;

public class SortCharacters {
    public static String sortAscending(String str) {
        return str.chars()
                .sorted()
                .mapToObj(c -> String.valueOf((char) c))
                .collect(Collectors.joining());
    }

    public static String sortDescending(String str) {
        return str.chars()
                .boxed()
                .sorted(Comparator.reverseOrder())
                .map(c -> String.valueOf((char) c.intValue()))
                .collect(Collectors.joining());
    }

    public static void main(String[] args) {
        String input = "java8";
        System.out.println("Ascending: " + sortAscending(input)); // Output: 8aajv
        System.out.println("Descending: " + sortDescending(input)); // Output: vjaa8
    }
}

/*

.mapToObj(c -> String.valueOf((char) c))
and

        java
Copy
        Edit
.map(c -> String.valueOf((char) c.intValue()))
Even though they ultimately achieve the same result, they differ in how the stream elements are handled under the hood.

🔹 1. .mapToObj(c -> String.valueOf((char) c))
This is used on an IntStream, which is a primitive stream of ints.

c here is a primitive int, so you can directly cast it to char.

        ✅ Example:

java
        Copy
Edit
"java8".chars()  // produces IntStream of ASCII values
.mapToObj(c -> String.valueOf((char) c))
Converts 106 (j) → 'j', etc.

Creates a stream of strings, like ["j", "a", "v", "a", "8"]

        ✔️ Efficient because it's working directly with primitives.

        🔹 2. .map(c -> String.valueOf((char) c.intValue()))
Used after boxing: str.chars().boxed()
This converts the IntStream into a Stream of Integer objects.

c here is an Integer object, so to get the primitive int value, you use c.intValue(), then cast to char.

        ✅ Example:

java
        Copy
Edit
"java8".chars().boxed() // Stream<Integer>
.map(c -> String.valueOf((char) c.intValue()))
        ✔️ Still works fine — just a bit less efficient due to:

Boxing overhead (int → Integer)

Unboxing later (Integer.intValue())

        ✅ Summary
Aspect	.mapToObj(c -> String.valueOf((char) c))	.map(c -> String.valueOf((char) c.intValue()))
Stream type	IntStream (primitive)	Stream<Integer> (boxed)
Performance	More efficient	Less efficient (boxing/unboxing)
Use case	When working directly with .chars()	When sorting/reversing (requires boxed type)
Readability	Clean and concise	Slightly more verbose
🔥 Pro Tip:
Use .mapToObj when you don't need to sort in reverse (since reverse sorting needs boxed types). Otherwise, use .boxed() + .sorted(Comparator.reverseOrder())*/
