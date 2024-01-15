package Starvation;

public class Starvation2 extends Thread {
    public Starvation2() {

    }
    public Starvation2(int priority) {
        setPriority(priority);
    }
    @Override
    public void run() {
        for (int i=0; i<Integer.MAX_VALUE;i++){}
        System.out.println("NAME   : " + getName());
    }
}
