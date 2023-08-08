package multithreading; 
import java.util.concurrent.Semaphore;

public class DiningPhilosophers {

    // The number of philosophers and forks
    private static final int NUM_PHILOSOPHERS = 5;

    // Create an array of semaphores to represent forks
    private Semaphore[] forks = new Semaphore[NUM_PHILOSOPHERS];

    // Global lock for synchronization
    private Object globalLock = new Object();

    // Constructor to initialize the semaphores
    public DiningPhilosophers() {
        for (int i = 0; i < NUM_PHILOSOPHERS; i++) {
            forks[i] = new Semaphore(1); // Each fork is initialized as available (unlocked)
        }
    }

    // Method to simulate a philosopher thinking
    private void think(int philosopherId) {
        System.out.println("Philosopher " + philosopherId + " is thinking.");
        try {
            Thread.sleep((long) (Math.random() * 1000)); // Simulate thinking by sleeping for a random time
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Method to simulate a philosopher eating
    private void eat(int philosopherId) {
        System.out.println("Philosopher " + philosopherId + " is eating.");
        try {
            Thread.sleep((long) (Math.random() * 1000)); // Simulate eating by sleeping for a random time
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Method to simulate a philosopher picking up forks
    private void pickForks(int philosopherId) {
        int leftFork = philosopherId;
        int rightFork = (philosopherId + 1) % NUM_PHILOSOPHERS;

        synchronized (globalLock) {
            try {
                forks[leftFork].acquire(); // Acquire the left fork
                forks[rightFork].acquire(); // Acquire the right fork
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    // Method to simulate a philosopher putting down forks
    private void putForks(int philosopherId) {
        int leftFork = philosopherId;
        int rightFork = (philosopherId + 1) % NUM_PHILOSOPHERS;

        forks[leftFork].release(); // Release the left fork
        forks[rightFork].release(); // Release the right fork
    }

    // Method to represent the actions of a philosopher
    private void philosopherAction(int philosopherId) {
        while (true) {
            think(philosopherId); // Philosopher is thinking
            pickForks(philosopherId); // Philosopher is trying to pick up forks to eat
            eat(philosopherId); // Philosopher is eating
            putForks(philosopherId); // Philosopher is putting down forks after eating
        }
    }

    // Main method to start the simulation
    public static void main(String[] args) {
        DiningPhilosophers dp = new DiningPhilosophers();
        for (int i = 0; i < NUM_PHILOSOPHERS; i++) {
            final int philosopherId = i;
            Thread philosopherThread = new Thread(() -> dp.philosopherAction(philosopherId));
            philosopherThread.start();
        }
    }
}
