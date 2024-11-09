package ProducerConsumer;

/**
 * The Logger class keeps track of successful message processing and errors.
 */
public class Logger {
    private int successCount = 0;
    private int errorCount = 0;

    public synchronized void logSuccess() {
        successCount++;
    }

    public synchronized void logError() {
        errorCount++;
    }

    public synchronized void printLog() {
        System.out.println("Total Successes: " + successCount);
        System.out.println("Total Errors: " + errorCount);
    }
}
