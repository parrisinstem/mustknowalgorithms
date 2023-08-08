package multithreading;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ArrayBlockingQueue;

public class RestaurantSystem {
    private static final int MAX_COUNTER_CAPACITY = 5; // Maximum dishes that the serving counter can hold
    private static BlockingQueue<Integer> servingCounter = new ArrayBlockingQueue<>(MAX_COUNTER_CAPACITY);

    public static void main(String[] args) {
        // Create and start cook threads
        for (int i = 1; i <= 2; i++) {
            int cookId = i;
            new Thread(() -> {
                while (true) {
                    int dishId = prepareDish(cookId); // Generate a unique dish ID for the prepared dish
                    try {
                        servingCounter.put(dishId); // Put the prepared dish into the serving counter queue
                        System.out.println("Cook " + cookId + " Prepared Dish " + dishId);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }

        // Create and start waiter thread
        new Thread(() -> {
            while (true) {
                try {
                    int dishId = servingCounter.take(); // Take a dish from the serving counter queue
                    int waiterId = 1; // For simplicity, we assume only one waiter
                    System.out.println("Waiter " + waiterId + " Took Dish " + dishId);
                    Thread.sleep(2000); // Simulate the time taken by the waiter to serve the dish
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        // Create and start customer thread
        new Thread(() -> {
            int customerId = 1; // For simplicity, we assume only one customer
            while (true) {
                try {
                    int dishId = servingCounter.take(); // Take a dish from the serving counter queue
                    System.out.println("Customer " + customerId + " Consumed Dish " + dishId);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    // Method to simulate dish preparation (e.g., generate a unique dish ID)
    private static int prepareDish(int cookId) {
        int dishId = cookId * 1000 + servingCounter.size() + 1; // Generate a unique dish ID
        return dishId;
    }
}
