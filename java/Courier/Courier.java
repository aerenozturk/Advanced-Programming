package Courier;

public class Courier {
    private String message;
    private boolean empty;

    public Courier() {
        empty=true;
    }

    public synchronized String take() {
        while(empty) {
            try {
                wait();
            } catch(InterruptedException e) {}
        }
        empty=true;
        notifyAll();
        return message;
    }

    public synchronized void pickUp(String message) {
        while(!empty) {
            try {
                wait();
            } catch(InterruptedException e) {}
        }
        empty=false;
        this.message=message;
        notifyAll();
    }
    
}
