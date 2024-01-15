package Starvation;
import java.math.BigInteger;
import java.util.Random;
public class Program {
    public static void main(String[] args) {
        starvation1();
        starvation2();
}
    private static void starvation1() {
        Starvation1[] starvations = new  Starvation1[10];
        Random rnd = new Random();

        for (int i = 0; i < starvations.length; i++) {
            starvations[i] = new Starvation1(BigInteger.probablePrime(80, rnd),BigInteger.probablePrime(80, rnd) );
            starvations[i].start();
        }
    } 
    private static void starvation2() {
        Starvation2[] starvations = new  Starvation2[10];
        for (int i = 0; i < starvations.length; i++) 
            starvations[i] = new Starvation2(i+1);

            for(Starvation2 starvation : starvations)
            starvation.start();
    }
}