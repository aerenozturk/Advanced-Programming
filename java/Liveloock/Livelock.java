package Liveloock;

public class Livelock {

    private final String name;
    private SaltShaker saltShaker;
    private boolean isHungry;

    public Livelock(String name) {
        this.name=name;
        isHungry=true;

    }
    public String getName() {
        return name;
    }
    private boolean isOwner() {
        return saltShaker.getOwner() != this;
    }
    protected SaltShaker getSaltShaker() {
        return saltShaker;
    }
    protected void setSaltShaker(SaltShaker saltShaker) {
        this.saltShaker=saltShaker;
    }
    public void passSaltShakerTo(Livelock person) {
        while(isHungry) {
            if(!isOwner()) {
                try {
                    Thread.sleep(1000);
                } catch(InterruptedException ex){continue;}
            }
        
        if(person.isHungry) {
            System.out.printf("%s says: %s can first use %s. %n", getName(),person.getName(),saltShaker.getName());
            saltShaker.setOwner(person);
            continue;
        }
        isHungry=false;
        saltShaker.setOwner(person);
        System.out.printf("%s says: full %n", getName());
        }
    }
}        