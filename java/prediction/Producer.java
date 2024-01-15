package prediction;

import java.util.BitSet;
import java.util.Random;

public class Producer extends Thread{

    private final Random rnd;
    private volatile int val;
    public final BitSet isDone;
    private final int numOfPredictiors;
    public final Object notifier;


    public Producer(int numOfPredictiors) {
        rnd = new Random();
        notifier= new Object();
        this.numOfPredictiors = numOfPredictiors;
        isDone = new BitSet(numOfPredictiors);
        isDone.set(0,numOfPredictiors,false);
    }
    public int value() {
        return val;
    }
    @Override
    public void run() {
       while(true) {
            synchronized (isDone) {
                isDone.set(0,numOfPredictiors*2);
                System.out.println("Number:" + val);

                synchronized (notifier) {
                    notifier.notifyAll();
                }
                synchronized(this) {
                    try {
                        wait(); //wait for the consumer to finish processing before producing another number
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
            }
       }
    }
     
}