package sonHafta;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class BoundedBuffer {
    private final Lock lock = new ReentrantLock();
    private final Condition notFull = lock.newCondition();
    private final Condition notEmpty = lock.newCondition();

    private final int[] buffer = new int[5];
    private int putptr, takeptr, count;

    public void put(int x) throws InterruptedException {
        lock.lock();
        try {
            while (count == buffer.length) {
                notFull.await(); // Wait until buffer is not full
            }
            buffer[putptr] = x;
            if (++putptr == buffer.length) putptr = 0;
            ++count;
            notEmpty.signal(); // Notify that buffer is not empty
        } finally {
            lock.unlock();
        }
    }

    public int take() throws InterruptedException {
        lock.lock();
        int x = 0; // Declare the variable x
        try {
            while (count == 0) {
                notEmpty.await(); // Wait until buffer is not empty
            }
            x = buffer[takeptr];
            if (++takeptr == buffer.length) takeptr = 0;
            --count;
            notFull.signal(); // Notify that buffer is not full
        } finally {
            lock.unlock();
        }
        return x;
    }
}

 class ConditionExample {
    public static void main(String[] args) {
        BoundedBuffer buffer = new BoundedBuffer();

        // Producer
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    buffer.put(i);
                    System.out.println("Put: " + i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        // Consumer
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    System.out.println("Take: " + buffer.take());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
