package yemekex;

public class Program {
    public static void main(String[] args){
        Headwaiter waiter= new Headwaiter();
        Customer customer=new Customer(waiter);
        customer.start();
        waiter.start();
    }
}
