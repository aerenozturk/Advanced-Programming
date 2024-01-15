package JavaApplication1.code;

public class synchronoizedConuter2 {
    private long c;
    private final Object lock = new Object();

    public synchronoizedConuter2() {
        c=0;
    }
    public void increment(){
        c++;
}
    public void decrement(){
        c--;
    }
    public long value(){
        synchronized(lock) {
            return c;
        }
    }

}

