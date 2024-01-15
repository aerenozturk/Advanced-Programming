package sonHafta;
import java.util.concurrent.CountDownLatch;

 class CountDownLatchExample {

    // Helper method to simulate a task that takes time to complete
    private static void performTask(int taskId, CountDownLatch latch) {
        try {
            System.out.println("Task " + taskId + " is starting.");
            Thread.sleep(1000); // Simulating work (e.g., network call, file I/O)
            System.out.println("Task " + taskId + " is completed.");
        } catch (InterruptedException e) {
            System.out.println("Task " + taskId + " interrupted.");
        } finally {
            latch.countDown(); // Decrement the count of the latch
        }
    }

    public static void main(String[] args) throws InterruptedException {
        int numberOfTasks = 3;
        CountDownLatch latch = new CountDownLatch(numberOfTasks);

        // Creating and starting threads
        for (int i = 0; i < numberOfTasks; i++) {
            final int taskId = i;
            new Thread(() -> performTask(taskId, latch)).start();
        }

        // Main thread will wait until all tasks are completed
        System.out.println("Waiting for tasks to complete...");
        latch.await(); // Wait for the latch's count to reach zero

        System.out.println("All tasks are completed. Proceeding with the next step.");
    }
}

