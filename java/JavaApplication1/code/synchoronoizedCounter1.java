package JavaApplication1.code;

public class synchoronoizedCounter1 {
    private long c;
    public synchoronoizedCounter1() {
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
