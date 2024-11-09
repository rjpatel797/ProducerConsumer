package ProducerConsumer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * The MessageQueue class provides a thread-safe queue for message sharing
 * between producer and consumer threads.
 */
public class MessageQueue {
    private Queue<String> queue = new LinkedList<>();
    private final int CAPACITY = 10;

    /**
     * Adds a message to the queue if space is available.
     * If the queue is full, the producer thread will wait.
     */
    public synchronized void produce(String message) throws InterruptedException {
        while (queue.size() == CAPACITY) {
            wait(); // Wait if the queue is full
        }
        queue.add(message);
        notifyAll(); // Notify consumer threads
    }

    /**
     * Retrieves and removes a message from the queue if available.
     * If the queue is empty, the consumer thread will wait.
     */
    public synchronized String consume() throws InterruptedException {
        while (queue.isEmpty()) {
            wait(); // Wait if the queue is empty
        }
        String message = queue.poll();
        notifyAll(); // Notify producer threads
        return message;
    }
}
