/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fibonacci.ınterrrupt;


/**
 *
 * @author user
 */
import java.util.Random;

public class RandomFibonacciGenerator {
    public static void main(String[] args) {
        Thread fibonacciThread = new Thread(() -> {
            long startTime = System.currentTimeMillis();
            Random random = new Random();
            long fib1 = 0, fib2 = 1;
            System.out.println("Randomly generated Fibonacci Series (first 30 numbers):");

            for (int i = 0; i < 30; i++) {
                long current = fib1 + fib2;
                System.out.print(current + " ");

                // Randomly sleep between 0 to 100 milliseconds
                try {
                    Thread.sleep(random.nextInt(101));
                } catch (InterruptedException e) {
                    System.out.println("\nExecution interrupted due to timeout.");
                    break;
                }

                fib1 = fib2;
                fib2 = current;
            }

            System.out.println("\nExecution time: " + (System.currentTimeMillis() - startTime) + "ms");
        });

        fibonacciThread.start();

        try {
            // Wait for the Fibonacci thread to finish or time out
            fibonacciThread.join(2000); // Timeout after 2 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

