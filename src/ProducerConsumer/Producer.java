package ProducerConsumer;

/**
 * The Producer class generates messages and adds them to the message queue.
 */
public class Producer implements Runnable {
    private MessageQueue queue;

    public Producer(MessageQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        int messageCount = 0;
        while (true) {
            String message = "Message " + messageCount++;
            try {
                queue.produce(message);
                System.out.println("Produced: " + message);
                Thread.sleep(500); // Simulate time taken to produce
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}
