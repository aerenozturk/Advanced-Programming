package Liveloock;

public class SaltShaker {
    private final String name;
    private Livelock owner;

    public SaltShaker(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public Livelock getOwner() {
        return owner;
    }
    public synchronized void setOwner(Livelock owner) {
        this.owner = owner;
        this.owner.setSaltShaker(this);
    }
}
