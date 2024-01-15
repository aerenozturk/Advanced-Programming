package sonHafta;
import java.util.concurrent.locks.ReentrantLock;

class SharedResource {
    private final ReentrantLock lock = new ReentrantLock();

    // Method that uses the lock
    public void accessResource() {
        lock.lock();  // Acquire the lock
        try {
            // Critical section: Only one thread can execute this at a time
            System.out.println("Resource is being accessed by " + Thread.currentThread().getName());
            // Simulate some work
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted");
        } finally {
            lock.unlock();  // Always ensure the lock is released in the finally block
        }
    }
}

class WorkerThread extends Thread {
    private SharedResource resource;

    public WorkerThread(SharedResource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        resource.accessResource();
    }
}

class ReentrantLockExample {
    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource();

        // Create and start multiple threads
        WorkerThread t1 = new WorkerThread(sharedResource);
        WorkerThread t2 = new WorkerThread(sharedResource);
        t1.start();
        t2.start();
    }
}
