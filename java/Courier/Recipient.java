package Courier;

import java.util.Random;

public class Recipient implements Runnable {
    private final Courier courier;

    public Recipient(Courier courier) {
        this.courier = courier;
    }


    @Override
    public void run() {
        Random random = new Random();
        String str = courier.take();
        for(; !str.equals("DONE"); str = courier.take()) {
            System.out.format("message received: %s%n", str);
            try {
                Thread.sleep(random.nextInt(3000));
            } catch(InterruptedException e) {}
        }
            System.out.format("message received: %s%n", str);
    }
}
