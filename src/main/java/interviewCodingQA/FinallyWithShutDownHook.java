package interviewCodingQA;

public class FinallyWithShutDownHook {
    public static void main(String[] args) {

        Runtime.getRuntime().addShutdownHook(new Thread(
                ()-> System.out.println("Shutting down...")
        ));
        try{
            System.out.println("Inside Finally try block");
            System.exit(0);
        }finally{
            System.out.println("Inside Finally finally block");
        }
    }
}

/*
Java Interview: Does finally Execute if System.exit(0) is Called in a try Block?

When working with Java, we rely on the finally block to ensure critical cleanup tasks—like closing files, releasing resources, or
logging messages—are always executed. But what happens if we explicitly terminate the JVM using System.exit(0) within a try block? 🤔
        🔹 Understanding finally
        In Java, the finally block is guaranteed to execute after a try block, except in a few specific scenarios, such as:
        ✅ If the JVM crashes due to an error (e.g., OutOfMemoryError).
        ✅ If the process is forcefully terminated (e.g., kill -9 in Unix).
        ✅ If System.exit(0) is called, which shuts down the JVM immediately.

        ❌ In the Example, The finally block does not execute because System.exit(0)abruptly terminates the JVM before it has a chance to run.

        🔎 Alternative Approach
If you want to ensure cleanup tasks always execute, consider using shutdown hooks instead of relying solely on finally:*/
