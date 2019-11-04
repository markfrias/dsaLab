package linear_structures;

import java.util.Timer;
import java.util.TimerTask;

class SupermarketTask extends TimerTask {
    public void run(){
        SupermarketSimulation.timeCounter++;
        System.out.println(SupermarketSimulation.timeCounter);

        if (SupermarketSimulation.timeCounter >= 50){
            cancel();
        }

        if (SupermarketSimulation.timeCounter == SupermarketSimulation.firstArrivalTime){
            System.out.println("First customer has arrived.");
            SupermarketSimulation.customerQueue.enqueue(SupermarketSimulation.firstCustomer);
            SupermarketSimulation.customerQueue.print();
            SupermarketSimulation.firstServiceTime = (int) (Math.random() * ((4 - 1) + 1)) + 1;
            System.out.println("Service time is " +  SupermarketSimulation.firstServiceTime);
        }

        if (SupermarketSimulation.timeCounter == (SupermarketSimulation.firstArrivalTime + SupermarketSimulation.firstServiceTime)){
            SupermarketSimulation.customerQueue.dequeue();
            System.out.println("The previous customer has left");
            SupermarketSimulation.customerQueue.print();
            SupermarketSimulation.arrivalTime = SupermarketSimulation.timeCounter + (int) (Math.random() * ((4 - 1) + 1)) + 1;
            System.out.println("The arrival time is " + SupermarketSimulation.arrivalTime);
        }

        if (SupermarketSimulation.timeCounter == SupermarketSimulation.arrivalTime){
            Customer newCustomer = new Customer(SupermarketSimulation.customerNumber++);
            System.out.println("Customer " + SupermarketSimulation.customerNumber + "has arrived");
            SupermarketSimulation.customerQueue.enqueue(newCustomer);
            SupermarketSimulation.customerQueue.print();
            SupermarketSimulation.serviceTime = (int) (Math.random() * ((4 - 1) + 1)) + 1 + SupermarketSimulation.timeCounter;
            System.out.println("Service time is " + SupermarketSimulation.serviceTime);
            SupermarketSimulation.arrivalTime = SupermarketSimulation.timeCounter + (int) (Math.random() * ((4 - 1) + 1)) + 1;
            System.out.println("The arrival time is " + SupermarketSimulation.arrivalTime);
        }

        if (SupermarketSimulation.timeCounter == SupermarketSimulation.serviceTime){
            SupermarketSimulation.customerQueue.dequeue();
            System.out.println("The previous customer has left");
            SupermarketSimulation.customerQueue.print();

        }

    }
}
public class SupermarketSimulation {
    public static int timeCounter = 0;
    static int customerNumber;
    public static Queue<Customer> customerQueue = new Queue<>();
    static int firstArrivalTime = 0;
    static int arrivalTime = 0;
    static int serviceTime = 0;
    static int firstServiceTime = 0;
    // Assign time of arrival to new Customer object
    public static Customer firstCustomer = new Customer(0);

    public static void main(String[] args){

        Timer timer = new Timer();
        TimerTask task = new SupermarketTask();

        timer.scheduleAtFixedRate(task, 1000, 1000);


        // Determine first customer arrival
        int firstCustomerArrival = (int) (Math.random() * ((4 - 1) + 1)) + 1;
        firstArrivalTime += firstCustomerArrival;



    }
}
