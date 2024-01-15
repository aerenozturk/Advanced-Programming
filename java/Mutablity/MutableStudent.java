package Mutablity;

public class MutableStudent {
    private String name;
    private String surname;

    public MutableStudent(String name, String surname) {
        this.name = name;
        this.surname= surname;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name=name;
    }
    public String getSurname() {
        try{
            Thread.sleep(1);
        } catch(InterruptedException ex) {
        }
        return surname;
    }
    public void setSurname(String surname) {
        this.surname=surname;
    }

    @Override
    public String toString() {
        return name + " " + surname;
    }
}    

