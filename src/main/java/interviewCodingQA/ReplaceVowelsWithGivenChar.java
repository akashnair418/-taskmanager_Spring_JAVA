/*Java Coding Challenge: Replace All Vowels in a String! 🚀
Hey hashtag#JavaDevelopers! 👋
Here's a fun coding challenge to sharpen your skills. 🧠✨
        🎯 Task: Replace all vowels (a, e, i, o, u) in a given string with a specific character.

        🔹 Example:
Input: "Hello World"
Replacement: '*'
Output: "H*ll* W*rld"*/


package interviewCodingQA;

public class ReplaceVowelsWithGivenChar {

    public static void main(String[] args) {
        String input = "Hello World AJAU";
        char replacement = '*';
        System.out.println(replaceVowels(input,replacement));

    }

    public static String replaceVowels(String input, char replacement) {
        return input.replaceAll("[aeiouAEIOU]", String.valueOf(replacement));
    }
}
