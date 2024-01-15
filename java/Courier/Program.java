package Courier;

public class Program {
    
    public static void main(String[] args) {
        String packages[] = {"Evrak-1, Evrak-2, Evrak-3, Evrak-4"};
        Courier courier = new Courier();

        new Thread(new Sender(courier,packages)).start();
        new Thread(new Recipient(courier)).start();
    }
}
