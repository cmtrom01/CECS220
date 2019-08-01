/*
This class is a class that encapsulates the information for an employee
 */
import java.text.NumberFormat;
import java.util.Locale;

public class Employee {

    //create variables
    private String name;
    private int salary;
    private String SSNumber;

    //constructor for class
    Employee(String name, int salary, String SSNumber) throws SNNCharacterException, SNNLengthException {

        int charCounter = 0;
        this.name = name;
        this.salary = salary;
        this.SSNumber = SSNumber;

        for(int i = 0; i < SSNumber.length(); i++) {
            if(!Character.isDigit(SSNumber.charAt(i)) && SSNumber.charAt(i) != '-' && SSNumber.charAt(i) != ' ') {
                SNNCharacterException charExcept = new SNNCharacterException("You entered " + SSNumber +" which contains invalid characters.");
                throw charExcept;
            } else if(Character.isDigit(SSNumber.charAt(i)) || SSNumber.charAt(i) == '-') {
                charCounter++;
            }
        }

        if(charCounter != 11) {
            SNNLengthException lenExcept = new SNNLengthException("You entered " + SSNumber +" which is the invalid length. The length is " + SSNumber.length() + " and should be 11 including dashes.");
            throw lenExcept;
        }

    }


    //toString method
    public String toString() {
       String finalStr = "";

       NumberFormat fmt = NumberFormat.getCurrencyInstance(Locale.US);

       String salaryStr = fmt.format(salary);

       finalStr = "The employee name is " + name.toString() + "\nThe employee salary is " + salaryStr + "\nThe SSN is " + SSNumber.toString();

       return finalStr;
    }

    //getter method for name
    public String getName() {
        return name;
    }

    //getter method for salary
    public int getSalary() {
        return salary;
    }

    //getter method for SSNumber
    public String getSSNumber() {
        return SSNumber;
    }

    //setter method for name
    public void setName(String name) {
        this.name = name;
    }

    //getter method for salary
    public void setSalary(int salary) {
        this.salary = salary;
    }

    //getter method for SSNumber
    public void setSSNumber(String SSNumber) throws SNNCharacterException, SNNLengthException {

        this.SSNumber = SSNumber;

        int charCounter = 0;

        for(int i = 0; i < SSNumber.length(); i++) {
            if(!Character.isDigit(SSNumber.charAt(i)) && SSNumber.charAt(i) != '-' && SSNumber.charAt(i) != ' ') {
                SNNCharacterException charExcept = new SNNCharacterException("You entered " + SSNumber +" which contains invalid characters.");
                throw charExcept;
            } else if(Character.isDigit(SSNumber.charAt(i)) || SSNumber.charAt(i) == '-') {
                charCounter++;
            }
        }


        if(charCounter != 11) {
            SNNLengthException lenExcept = new SNNLengthException("You entered " + SSNumber +" which is the invalid length. The length is " + SSNumber.length() + " and should be 11 including dashes.");
            throw lenExcept;
        }
    }

    //equals method
    public boolean equals(Employee obj) {
        if(SSNumber.equals(((Employee)obj).getSSNumber())) {
            return true;
        } else if (name.equalsIgnoreCase(((Employee)obj).getName())){
            return true;
        } else {
            return false;
        }
    }

}
