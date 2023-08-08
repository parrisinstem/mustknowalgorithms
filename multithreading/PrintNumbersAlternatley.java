package multithreading;

public class PrintNumbersAlternately {
    // Nested class representing the Printer object
    static class Printer {
        private int num = 1; // Shared variable representing the current number to be printed
        private int maxNum; // Maximum number to be printed

        // Constructor to initialize the Printer with the maximum number to be printed
        public Printer(int maxNum) {
            this.maxNum = maxNum;
        }

        // Synchronized method to print even numbers
        public synchronized void printEven() {
            // Loop until the current number is less than or equal to the maximum number
            while (num <= maxNum) {
                // Check if the current number is even
                if (num % 2 == 0) {
                    // Print the current even number along with the name of the thread
                    System.out.println(Thread.currentThread().getName() + ": " + num);
                    num++; // Increment the current number for the next iteration
                    notifyAll(); // Notify all waiting threads that the condition has changed
                } else {
                    // If the current number is odd, wait until it becomes even
                    try {
                        wait(); // Release the lock and wait for another thread to notify
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        // Synchronized method to print odd numbers
        public synchronized void printOdd() {
            // Loop until the current number is less than or equal to the maximum number
            while (num <= maxNum) {
                // Check if the current number is odd
                if (num % 2 != 0) {
                    // Print the current odd number along with the name of the thread
                    System.out.println(Thread.currentThread().getName() + ": " + num);
                    num++; // Increment the current number for the next iteration
                    notifyAll(); // Notify all waiting threads that the condition has changed
                } else {
                    // If the current number is even, wait until it becomes odd
                    try {
                        wait(); // Release the lock and wait for another thread to notify
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Printer printer = new Printer(20); // Create a Printer object with the maximum number 20

        // Create two threads: one for printing even numbers and the other for printing odd numbers
        Thread evenThread = new Thread(printer::printEven, "EvenThread");
        Thread oddThread = new Thread(printer::printOdd, "OddThread");

        // Start both threads
        evenThread.start();
        oddThread.start();
    }
}
