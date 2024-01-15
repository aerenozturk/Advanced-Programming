package yemekex;

public class Order {
    private boolean received;
    private boolean submitted;
    private final Customer customer;
    private final Menu foods;

    public Order(Customer customer, Menu foods) {
        this.customer = customer;
        this.foods = foods;
        submitted=false;
        received=false;
    }
    //getters and setters for the variables
    public boolean isReceived() {
        return received;
    }
    public Menu getFoods() {
        return foods;
    }
    public Customer getCustomer() {
        return customer;
    }
    public boolean isSubmitted2Chef() {
        return submitted;
    }
    public void setSubmitted2Chef(boolean state) {
        submitted = state;
    }
    public void makeReceived(boolean state) {
        received = state;
    }
}
