package prediction;
import java.util.Random;
public class Predictor extends Thread {
    private final Random rnd;
    private final int numOfPredictiors;
    private volatile int val;
    private final Producer producer;

    public Predictor(Producer producer, int numOf Predictiors) {
        rnd = new Random();
        this.numOfPredictiors = numOfPredictiors;
        this.producer = producer;
    }

    @Override
    public void run() {
        while(true) {
            val = rnd.nextInt(numOfPredictiors*2);
            if(producer.value() == val)
                System.out.println(getName() + "predicted accurately (" + val + ")");
            else
                System.out.println(getName() + "predicted inaccurately (" + val + ")");
            // update isDone
            synchronized (producer.isDone) {
                producer.isDone.set(Integer.parseInt(getName().substring(7))-1,true);
            }   
            // notify producer if all predictors done
            synchronized(producer) {
                if(producer.isDone.cardinality()==numOfPredictiors) {
                    producer.notify();
                }
            }
            // wait for producer to complete
            synchronized(producer.notifier) {
                try {
                    if(producer.isDone.get(Integer.parseInt(getName().substring(7))-1))
                        producer.notifier.wait();
                } catch (InterruptedException ex) {
                }
            }
        }
    }
}
