package linear_structures;

import java.util.Timer;
import java.util.TimerTask;

class SupermarketTask extends TimerTask {
    public void run(){
        SupermarketSimulation.timeCounter++;
        System.out.println(SupermarketSimulation.timeCounter);

        if (SupermarketSimulation.timeCounter >= 720){
            cancel();
            System.exit(0);
        }

        // First customer's arrival
        if (SupermarketSimulation.timeCounter == SupermarketSimulation.firstArrivalTime){
            System.out.println("First customer has arrived.");

            // Determine customer's service time
            SupermarketSimulation.serviceTime = ((int) (Math.random() * ((4 - 1) + 1)) + 1)  + SupermarketSimulation.timeCounter;
            System.out.println("Service will be completed in minute  " +  SupermarketSimulation.serviceTime);

            // Schedule arrival of next customer
            SupermarketSimulation.arrivalTime = SupermarketSimulation.timeCounter + (int) (Math.random() * ((4 - 1) + 1)) + 1;
            System.out.println("The arrival time of the next customer is minute " + SupermarketSimulation.arrivalTime);
        }

        // Customer arrival
        if (SupermarketSimulation.timeCounter == SupermarketSimulation.arrivalTime){

            // Tell the user that a customer has arrived
            System.out.println("Customer " + SupermarketSimulation.customerNumber + " has arrived.");

            // Enqueue next customer
            SupermarketSimulation.customerQueue.enqueue(new Customer(SupermarketSimulation.customerNumber++));
            SupermarketSimulation.customerQueue.print();

            // Schedule the arrival of the next customer
            SupermarketSimulation.arrivalTime = ((int) (Math.random() * ((4 - 1) + 1)) + 1) + SupermarketSimulation.timeCounter;
            System.out.println("The next customer will arrive on minute " + SupermarketSimulation.arrivalTime);
        }

        // Service completion
        if (SupermarketSimulation.timeCounter == SupermarketSimulation.serviceTime){

            // Tell the user that service for the last user was completed
            System.out.println("Customer has been serviced.");

            // Dequeue next customer to be serviced
            try {
                SupermarketSimulation.customerQueue.dequeue();
            } catch (EmptyListException e){
                System.out.println("There are no more customers to be serviced");
            }

            // Determine customer's service completion time
            SupermarketSimulation.serviceTime = ((int) (Math.random() * ((4 - 1) + 1)) + 1) + SupermarketSimulation.timeCounter;
        }



        /*if (SupermarketSimulation.timeCounter == (SupermarketSimulation.firstServiceTime)){

            System.out.println("Customer " + SupermarketSimulation.customerQueue.dequeue() + " has left.");
            SupermarketSimulation.customerQueue.print();

        }

        if (SupermarketSimulation.timeCounter == SupermarketSimulation.arrivalTime){
            Customer newCustomer = new Customer(++SupermarketSimulation.customerNumber);
            System.out.println("Customer " + SupermarketSimulation.customerNumber + "has arrived");
            SupermarketSimulation.customerQueue.enqueue(newCustomer);
            SupermarketSimulation.customerQueue.print();
            SupermarketSimulation.serviceTime = ((int) (Math.random() * ((4 - 1) + 1)) + 1) + SupermarketSimulation.timeCounter;
            System.out.println("Service time is " + SupermarketSimulation.serviceTime);
            SupermarketSimulation.arrivalTime = SupermarketSimulation.timeCounter + (int) (Math.random() * ((4 - 1) + 1)) + 1;
            System.out.println("The arrival time is " + SupermarketSimulation.arrivalTime);
        }

        if (SupermarketSimulation.timeCounter == SupermarketSimulation.serviceTime){
            System.out.println("Customer " + SupermarketSimulation.customerQueue.dequeue() + " has left.");
            SupermarketSimulation.customerQueue.print();

        }*/



    }
}
public class SupermarketSimulation {
    static int timeCounter = 0;
    static int customerNumber = 2;
    static Queue<Customer> customerQueue = new Queue<>();
    static int firstArrivalTime = 0;
    static int arrivalTime = 0;
    static int serviceTime = 0;
    static int firstServiceTime = 0;
    // Assign time of arrival to new Customer object
    public static Customer firstCustomer = new Customer(0);

    public static void main(String[] args){

        Timer timer = new Timer();
        TimerTask task = new SupermarketTask();

        timer.scheduleAtFixedRate(task, 100, 10);


        // Determine first customer arrival time
        int firstCustomerArrival = (int) (Math.random() * ((4 - 1) + 1)) + 1;
        firstArrivalTime += firstCustomerArrival;






    }
}
