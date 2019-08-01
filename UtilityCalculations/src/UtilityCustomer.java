/*
This class is an abstract class that will be the parent for the gas and electric customer classes
 */


public abstract class UtilityCustomer implements Comparable<UtilityCustomer> {

    //instance variable for the customer account number
    private int accountNumber;

    //abstract method called calculateBill that returns bill amount as a double
    public abstract double calculateBill();

    //constructor that initializes accountNumber
    UtilityCustomer(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    //compare to method to compare
    @Override
    public int compareTo(UtilityCustomer o) {

        int result;

        if(o.getAccountNumber() > accountNumber) {

            result = 0;

        } else if(o.getAccountNumber() < accountNumber) {

            result = 1;

        } else {

            result = 2;
        }
        return result;
    }


    //mutator method for accountNumber
    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    //accessor method for accountNumber
    public int getAccountNumber() {
        return accountNumber;
    }

    //toString method that converts the accountNumber to a string and returns this string
    public String toString() {

         String finalStr = "";
         String accountNumberStr = Integer.toString(accountNumber);
         finalStr = "The account number is: " + accountNumberStr;

         return finalStr;
    }



}
