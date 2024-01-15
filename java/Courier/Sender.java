package Courier;

import java.util.Random;

public class Sender implements Runnable{
    private final Courier courier;
    private final String[] packages;

    public Sender(Courier courier, String[] packages) {
        this.courier = courier;
        this.packages = packages;
    }
    @Override
    public void run() {
        Random random = new Random();

        for(String p: packages) {
            courier.pickUp(p);
            try {
                Thread.sleep(random.nextInt(3000));
            } catch(InterruptedException e) {}
        }
        courier.pickUp("DONE");
    }
    
}
