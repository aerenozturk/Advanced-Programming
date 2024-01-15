package Mutablity;

public class Program {
    public static void main(String[] args) {
        mutableObject();
        immutableObject();
    }

    private static void mutableObject() {
        MutableStudent ms = new MutableStudent("John", "Doe");

        new Thread(() -> {
            String name = ms.getName();
            String surname = ms.getSurname();
            System.out.println("Thread 1: " + name + " " + surname);
        } ).start();

        new Thread(() -> {
        ms.setName("eren");
        ms.setSurname("jobs");
            System.out.println("Thread 2: " + ms);
        } ).start();

    }
    private static void immutableObject() {
        ImmutableStudent is =new ImmutableStudent("John","Doe");

        new Thread(() -> {
            System.out.println("1-"+is);
        }).start();

        new Thread(() -> {
            System.out.println("2-"+is);
        }).start();
    }
}
