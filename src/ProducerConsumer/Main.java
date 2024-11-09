package ProducerConsumer;

/**
 * The Main class initializes and starts the producer and consumer threads.
 */
public class Main {
    public static void main(String[] args) {
        // Initialize the shared message queue
        MessageQueue queue = new MessageQueue();
        
        // Create producer and consumer instances
        Producer producer = new Producer(queue);
        Consumer consumer = new Consumer(queue);

        // Start producer and consumer threads
        Thread producerThread = new Thread(producer);
        Thread consumerThread = new Thread(consumer);

        producerThread.start();
        consumerThread.start();
    }
}
