package interviewCodingQA;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class SortWordsByLength {

    public static void main(String[] args) {

        String input ="Java Streams are more efficient and powerful";

        String result = Arrays.stream(input.split("\\s+"))
                .sorted(Comparator.comparingInt(String::length))  // to make it descending use .reversed()
                .collect(Collectors.joining(" "));
        System.out.println(result);
    }
}
