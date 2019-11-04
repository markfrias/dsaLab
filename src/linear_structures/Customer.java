package linear_structures;
public class Customer {

    // Fields for customer
    private int customerNumber;

    // Constructor for Customer object
    public Customer(int objectNumber){
        customerNumber = objectNumber;
    }


    public String toString(){
        return Integer.toString(customerNumber);
    }

}
