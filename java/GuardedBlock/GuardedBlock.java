package GuardedBlock;


public class GuardedBlock {
    
    private boolean condition;

    public GuardedBlock(boolean condition) {
        this.condition = condition;
    }
    public void wastedApproach() {
        while(condition) {
            System.out.println("LOOP");
        }
        System.out.println("The end of Method");
    }
    public synchronized void unwastedApproach() {
        while(condition) {
            try {
                wait();
            } catch(InterruptedException ex) {
                continue;
            }
        }
        System.out.println("The end of Method");
    }
    public synchronized void setCondition(boolean condition) {
        this.condition=condition;
        notifyAll();
    }
}
