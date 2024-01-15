package sonHafta;
import java.util.concurrent.locks.StampedLock;

class SharedResource {
    private final StampedLock lock = new StampedLock();
    private int value = 0; // Shared resource

    // Method to write to the resource
    public void writeResource(int newValue) {
        long stamp = lock.writeLock(); // Acquire the write lock
        try {
            value = newValue;
            System.out.println(Thread.currentThread().getName() + " wrote value: " + value);
            Thread.sleep(1000); // Simulate some work
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted");
        } finally {
            lock.unlockWrite(stamp); // Always ensure the lock is released in the finally block
        }
    }

    // Method to read the resource using optimistic read
    public void readResource() {
        long stamp = lock.tryOptimisticRead(); // Get an optimistic read lock
        int currentValue = value;
        if (!lock.validate(stamp)) { // Check if the lock was still valid
            // Lock was not valid, upgrade to a read lock
            stamp = lock.readLock();
            try {
                currentValue = value;
            } finally {
                lock.unlockRead(stamp);
            }
        }

        System.out.println(Thread.currentThread().getName() + " read value: " + currentValue);
    }
}

class StampedLockExample {
    public static void main(String[] args) {
        final SharedResource sharedResource = new SharedResource();

        // Create writer thread
        Thread writer = new Thread(() -> sharedResource.writeResource(10));

        // Create reader threads
        Thread reader1 = new Thread(() -> sharedResource.readResource());
        Thread reader2 = new Thread(() -> sharedResource.readResource());

        // Start the threads
        writer.start();
        reader1.start();
        reader2.start();

        try {
            writer.join();
            reader1.join();
            reader2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
