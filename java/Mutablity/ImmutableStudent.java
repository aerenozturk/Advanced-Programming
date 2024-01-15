package Mutablity;

public class ImmutableStudent {
    
    private final String name;
    private final String surname;

    public ImmutableStudent(String name, String surname) {
        this.name = name;
        this.surname= surname;
    }
    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }
    
    public ImmutableStudent getInstance(String name, String surname) { 
        return new ImmutableStudent(name, surname);
    }
    @Override public String toString() {
        return name + " " + surname;
    }
}
