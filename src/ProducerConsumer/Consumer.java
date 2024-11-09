package ProducerConsumer;

/**
 * The Consumer class retrieves messages from the queue and processes them.
 */
public class Consumer implements Runnable {
    private MessageQueue queue;

    public Consumer(MessageQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                String message = queue.consume();
                System.out.println("Consumed: " + message);
                Thread.sleep(1000); // Simulate time taken to consume
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}
