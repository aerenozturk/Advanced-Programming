package JavaApplication1.code;

public class counter {
    private long c;
    public counter() {
        c=0;
    }
    public void increment(){
        c++;
    }
    public void decrement()
    {
        c--;
    }
    public long value() {
        return c;
    }
}