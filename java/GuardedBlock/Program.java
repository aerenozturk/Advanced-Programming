package GuardedBlock;

public class Program {
    public static void main(String[] args) {
        GuardedBlock gb =new GuardedBlock(true);

        new Thread(() -> {
            gb.unwastedApproach();
        }).start();

        new Thread(() -> {
          gb.setCondition(false);
    }).start();
    }
}
