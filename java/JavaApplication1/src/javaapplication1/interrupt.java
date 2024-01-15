/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication1;
 
import java.util.Random;

public class Interrupt {
    public static void main(String[] args) {
        InterruptByException thread1 = new InterruptByException();
        InterruptByThrowException thread2 = new InterruptByThrowException();

        // Start both threads
        thread1.start();
        thread2.start();

        // Let the threads run for a while
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Interrupt the threads
        thread1.interrupt();
        thread2.interrupt();
    }

    


