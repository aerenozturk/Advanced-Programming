package JavaApplication1.code;

import java.util.concurrent.atomic.AtomicLong;

public class synchoronizedCounter3 {
    private AtomicLong c;

    public synchoronizedCounter3() {
        c=new AtomicLong(0);
    }
    public long increment() {
        return c.incrementAndGet();
    }
    public long decrement(){
        return c.decrementAndGet();
    }
    public long value() {
        return c.get();
        }
}
