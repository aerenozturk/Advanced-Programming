package Deadlock;

public class Deadlock {
    private final String name;

    public Deadlock(String name) {
        this.name= name;
    }
    public String getName() {
        return name;
    }
    public synchronized void sayHello(Deadlock bower) {
        System.out.format("&s said: &s" + "bugün bana merhaba dedi.&n", this.name,bower.getName());
        bower.sayHelloBack(this);
    }
    public synchronized void sayHelloBack(Deadlock bower) {
        System.out.format("&s said: &s" + "bugün bana merhaba dedi.&n", this.name,bower.getName());
    }

}
