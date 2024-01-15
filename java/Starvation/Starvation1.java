package Starvation;

import java.math.BigInteger;

public class Starvation1 extends Thread {
    private final BigInteger num1;
    private final BigInteger num2;

    public Starvation1 (BigInteger num1, BigInteger num2) {
        this.num1 = num1;
        this.num2 = num2;
    }
    private synchronized void getResult4Mult() {
        System.out.println("NAME    : " + getName());
        System.out.println ("RESULT  : "+ num1);
        System.out.println ("RESULT  : "+ num2);
        System.out.println("RESULT  : " + num1.multiply(num2));
        System.out.println();
        
    }
    @Override
    public void run() {
        getResult4Mult();
    }
}
