package CryptographyMutabilty;

public class Program {
    public static void main(String[] args) {
        mutableObject();
        immutableObject();
    }
    private static void mutableObject() {
        MutableCryptographicHash mch;
        try {
            mch = new MutableCryptographicHash();
        } catch (NoSuchAlgorithmException e) {
            System.out.println("Error: " + e.getMessage());
            return;
        }
        new Thread(() -> {
            System.out.println("Thread 1: " + mch.isTrue("ba4d3296aef7001e6d79e429202358e5"));
        }).start();
        }
    }

}
