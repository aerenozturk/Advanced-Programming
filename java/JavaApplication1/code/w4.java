/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
/**
 *
 * @author user
 */

package JavaApplication1.code;

public class code implements Runnable {
    private int number;

    public code(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        calculateFactorial();
    }

    public void calculateFactorial() {
        int result = 1;
        for (int i = 1; i <= number; i++) {
            result *= i;
        }
        System.out.println("The factorial of " + number + " is: " + result);
    }
}
public class w4 {
    public static void main(String[] args) {
        int number = 5; // The number for which we want to calculate the factorial

        // Create a new instance of the FactorialCalculator class and pass it the number
        code calculator = new code(number);

        // Create a new Thread object and pass it the FactorialCalculator object
        Thread thread = new Thread(calculator);

        // Start the thread
        thread.start();
    }
}


 /**
     * @param args the command line arguments
     */