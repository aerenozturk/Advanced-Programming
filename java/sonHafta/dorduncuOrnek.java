package sonHafta;
import java.util.concurrent.Semaphore;

class SharedResource {
    // Semaphore with 2 permits, allowing up to 2 concurrent accesses
    private final Semaphore semaphore = new Semaphore(2);

    public void accessResource() {
        try {
            semaphore.acquire(); // Acquire a permit
            System.out.println(Thread.currentThread().getName() + " is accessing the shared resource");
            Thread.sleep(1000); // Simulate some work with the resource
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted");
        } finally {
            semaphore.release(); // Release the permit
            System.out.println(Thread.currentThread().getName() + " has released the shared resource");
        }
    }
}

 class SemaphoreExample {
    public static void main(String[] args) {
        final SharedResource sharedResource = new SharedResource();

        // Create and start multiple threads
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(() -> sharedResource.accessResource(), "Thread-" + i);
            thread.start();
        }
    }
}

