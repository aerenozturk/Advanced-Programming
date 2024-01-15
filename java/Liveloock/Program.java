package Liveloock;

public class Program {
    public static void main(String[] args) {
        Livelock person1 = new Livelock("Person 1");
        Livelock person2 = new Livelock("Person 2");
        SaltShaker saltShaker = new SaltShaker("Salt Shaker");

        
        person2.setSaltShaker(saltShaker);

        new Thread(() -> {
            person1.passSaltShakerTo(person2);
        }).start();

        
        new Thread(() -> {
            person2.passSaltShakerTo(person1);
        }).start();
        
    }
    
}