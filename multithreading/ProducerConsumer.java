import java.util.concurrent.Semaphore;

public class ProducerConsumer {

    private static final int BUFFER_SIZE = 5;
    private static int[] buffer = new int[BUFFER_SIZE];
    private static int count = 0;

    private static Semaphore empty = new Semaphore(BUFFER_SIZE);
    private static Semaphore full = new Semaphore(0);
    private static Semaphore mutex = new Semaphore(1);

    static class Producer implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    empty.acquire(); // Wait until there is space in the buffer
                    mutex.acquire(); // Acquire the lock to access the buffer

                    produceItem(i); // Produce an item and add it to the buffer

                    mutex.release(); // Release the lock
                    full.release(); // Notify consumers that there is an item available in the buffer
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        private void produceItem(int item) {
            buffer[count] = item; // Add the item to the buffer
            count++;
            System.out.println("Produced: " + item);
        }
    }

    static class Consumer implements Runnable {
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    full.acquire(); // Wait until there is an item in the buffer
                    mutex.acquire(); // Acquire the lock to access the buffer

                    int item = consumeItem(); // Remove an item from the buffer and consume it

                    mutex.release(); // Release the lock
                    empty.release(); // Notify producers that there is an empty slot in the buffer

                    consumeItem(item);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        private int consumeItem() {
            count--;
            System.out.println("Consumed: " + buffer[count]);
            return buffer[count]; // Remove an item from the buffer and return it
        }
    }

    public static void main(String[] args) {
        Thread producerThread = new Thread(new Producer());
        Thread consumerThread = new Thread(new Consumer());

        producerThread.start(); // Start the producer thread
        consumerThread.start(); // Start the consumer thread

        try {
            producerThread.join(); // Wait for the producer thread to finish
            consumerThread.join(); // Wait for the consumer thread to finish
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
