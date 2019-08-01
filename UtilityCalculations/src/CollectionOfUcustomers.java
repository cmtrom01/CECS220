/*
This is the client class for Utility, gas, and electric customer. It stores up to 10 customers in an array and then prints
the array to the console.
 */

//import needed packages
import java.util.Scanner;

public class CollectionOfUcustomers {


    //main method
    public static void main(String args[]) {

        //array for customer objects of size 10
        UtilityCustomer[] customerArray = new UtilityCustomer[10];


        //declare variables to use as counters and yOrN for end program logic
        int i = 0;
        int counter = 0;
        int printCounter = 0;
        String yOrN;

        //declare input var and scanner object
        String input="";
        Scanner scan = new Scanner(System.in);

        //while loop to keep program running
        while (counter < 10) {

                System.out.println("Enter customer type (gas or electric): ");
                input = scan.next();


            if (input.equalsIgnoreCase("gas")) {

                //prompt user
                System.out.println("Enter account number: ");
                int accountNumber = scan.nextInt();

                System.out.println("Enter cubic meters used: ");
                double cubicMetersUsed = scan.nextDouble();

                GasCustomer gc = new GasCustomer(cubicMetersUsed, accountNumber);
                customerArray[i] = gc;
                printCounter++;


                //orders the array
                for(int l = 0; l < printCounter; l++) {

                        int comp = gc.compareTo(customerArray[l]);

                        if(comp == 1) {
                            UtilityCustomer tmp = customerArray[i];
                            customerArray[i] = customerArray[l];
                            customerArray[l] = tmp;
                        }
                }

                i++;
                counter++;


                System.out.println("Add another customer? Enter Y for yes or N for no. You can add up to 10 customers");
                yOrN = scan.next();

                if(yOrN.equalsIgnoreCase("N") || yOrN.equalsIgnoreCase("n")) {
                    break;
                }

            } else if (input.equalsIgnoreCase("electric")) {

                //prompt user
                System.out.println("Enter account number: ");
                int accountNumber = scan.nextInt();

                System.out.println("Enter kiloWatt hours used: ");
                double kWattHourUsed = scan.nextDouble();

                ElectricCustomer ec = new ElectricCustomer(kWattHourUsed, accountNumber);
                customerArray[i] = ec;
                printCounter++;


                //orders array
                for(int l = 0; l < printCounter; l++) {

                    int comp = ec.compareTo(customerArray[l]);

                    if(comp == 1) {
                        UtilityCustomer tmp = customerArray[i];
                        customerArray[i] = customerArray[l];
                        customerArray[l] = tmp;
                    }

                }

                i++;
                counter++;

                System.out.println("Add another customer? Enter Y for yes or N for no. You can add up to 10 customers");
                yOrN = scan.next();

                if(yOrN.equalsIgnoreCase("N") || yOrN.equalsIgnoreCase("n")) {
                        break;
                }

            }
        }

        if(counter == 10) {
            System.out.println("You have entered the maximum number of entries.");
        }

        //prints out array to console
        System.out.println("Here is your customer(s) information: ");

        for(int k = 0; k < printCounter; k++) {

            String info = customerArray[k].toString();
            System.out.println("Customer " + (k+1) + ": \n" + info);

        }

    }
}
