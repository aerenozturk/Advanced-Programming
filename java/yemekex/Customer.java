package yemekex;
import java.security.SecureRandom;
public class Customer extends Thread {
    private final Menu foods;
    private final Headwaiter waiter;
    private final SecureRandom sRandom;

    public Customer(Headwaiter waiter) {
        foods = new Menu(4);
        sRandom = new SecureRandom();
        this.waiter = waiter;
    }
    private void addOrder() throws InterruptedException {
        Menu menu= Menu.getAllFood();
        Thread.sleep(500);
        Food f= menu.get(sRandom.nextInt(menu.size()));
        foods.add(f);
        System.out.println("\t"+f.getName()+" ("+f.getTime()+"ms)");
    }
    
    @Override
    public void run() {
        while(true) {
            System.out.println(this.getName() + "'s orders are as follows:");
            try {
                foods.clear();
                for(int i = 0; i < 4; i++) {
                    addOrder();
                }
                waiter.setOrder(new Order(this, foods));
            }   catch (InterruptedException ex) {
            }

            synchronized(waiter) {
                waiter.notify();
            }

            synchronized(this) {
                try {
                    this.wait();
                } catch (InterruptedException ex) {
                }
            }
        }
    }
 }   


