package sonHafta;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class SharedResource {
    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private int value = 0; // Shared resource

    // Method to read the resource
    public void readResource() {
        readWriteLock.readLock().lock(); // Acquire the read lock
        try {
            System.out.println(Thread.currentThread().getName() + " reading value: " + value);
            Thread.sleep(1000); // Simulate some work
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted");
        } finally {
            readWriteLock.readLock().unlock(); // Always ensure the lock is released in the finally block
        }
    }

    // Method to write to the resource
    public void writeResource(int newValue) {
        readWriteLock.writeLock().lock(); // Acquire the write lock
        try {
            value = newValue;
            System.out.println(Thread.currentThread().getName() + " wrote value: " + value);
            Thread.sleep(1000); // Simulate some work
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted");
        } finally {
            readWriteLock.writeLock().unlock(); // Always ensure the lock is released in the finally block
        }
    }
}

 class ReadWriteLockExample {
    public static void main(String[] args) {
        final SharedResource sharedResource = new SharedResource();

        // Create reader threads
        Thread reader1 = new Thread(() -> sharedResource.readResource());
        Thread reader2 = new Thread(() -> sharedResource.readResource());

        // Create a writer thread
        Thread writer = new Thread(() -> sharedResource.writeResource(10));

        // Start the threads
        reader1.start();
        reader2.start();
        writer.start();

        try {
            reader1.join();
            reader2.join();
            writer.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
