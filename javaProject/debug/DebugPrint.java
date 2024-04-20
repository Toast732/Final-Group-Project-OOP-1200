package javaProject.debug;

public class DebugPrint {

    // Info message format, %s is the message.
    private static final String INFO_MESSAGE_FORMAT = "\033[94m[INFO] > %s\033[0m";

    private static final String ERROR_MESSAGE_FORMAT = "\033[91m[ERROR] > %s\033[0m";

    // Print method used by this class, to enable/disable debug messages easily.
    private static void print(String message) {
        System.out.println(message);
    }

    // Prints an info message
    public static void info(String message) {
        print(String.format(INFO_MESSAGE_FORMAT, message));
    }

    // Prints an error message
    public static void error(String message) {
        print(String.format(ERROR_MESSAGE_FORMAT, message));
    }
}
