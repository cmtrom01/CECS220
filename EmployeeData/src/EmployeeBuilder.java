/*
This class allows the user to create an array of employee records
 */
import java.util.Scanner;

public class EmployeeBuilder {

    //main function
    public static void main(String[] args) {

        //array of employee objects
        Employee[] employeeArray = new Employee[100];

        //declare variables
        int entryCounter = 0;
        double average = 0;
        String yOrN = "Y";
        int except = 0;

        //create scanner object
        Scanner scan = new Scanner(System.in);

        //while loop to keep program running
        while(entryCounter < 100 && yOrN.equalsIgnoreCase("y")) {

            //prompt user for information
            System.out.println("Enter employee name: ");
            String name = scan.nextLine();

            System.out.println("Enter Salary: ");
            int salary = Integer.parseInt(scan.nextLine());


            System.out.println("Enter social security number: ");
            String SSNumber = scan.nextLine();

            //try catch to create employee object
            Employee emp = null;
            try {
                emp = new Employee(name, salary, SSNumber);
                employeeArray[entryCounter] = emp;

            } catch (SNNCharacterException e) {
                e.printStackTrace();
                entryCounter--;
                except = 1;
            } catch (SNNLengthException e) {
                e.printStackTrace();
                entryCounter--;
                except = 1;
            }

            //check duplicate entries if it is not first entry
            if(entryCounter != 0) {
                Boolean duplicate = false;
                Boolean newDuplicate = false;

                //check for duplicate entries
                for (int k = 0; k < entryCounter; k++) {
                    if (emp.equals(employeeArray[k])) {
                        duplicate = true;
                    }
                }

                //handle duplicate entries
                while (duplicate == true) {

                    System.out.println("Error same name or SNN. Cannot enter duplicates.");
                    System.out.println("Enter employee name: ");
                    name = scan.nextLine();


                    System.out.println("Enter Salary: ");
                    salary = Integer.parseInt(scan.nextLine());

                    System.out.println("Enter social security number: ");
                    SSNumber = scan.nextLine();

                    try {
                        emp = new Employee(name, salary, SSNumber);
                        employeeArray[entryCounter] = emp;
                    } catch (SNNCharacterException e) {
                        e.printStackTrace();
                        entryCounter--;
                        except = 1;
                    } catch (SNNLengthException e) {
                        e.printStackTrace();
                        entryCounter--;
                        except = 1;
                    }

                    for (int k = 0; k < entryCounter; k++) {
                        if (emp.equals(employeeArray[k])) {
                            newDuplicate = true;
                        }
                    }

                    if (!newDuplicate) {
                        duplicate = false;
                    }

                }

                if (except != 1) {
                    try {
                        emp = new Employee(name, salary, SSNumber);
                        employeeArray[entryCounter] = emp;
                    } catch (SNNCharacterException e) {
                        e.printStackTrace();
                    } catch (SNNLengthException e) {
                        e.printStackTrace();
                    }

                }
            }

            entryCounter++;

            String finalStr = "";
            boolean aboveAverage;

            except = 0;

            //prompt user to enter another record or not
            System.out.println("Enter another record? Y for yes N for n");

            yOrN = scan.nextLine();

        }


        Boolean aboveAverage;
        String finalStr = "";
        double totalSal = 0;


        //calculate average
        for(int i=0; i < entryCounter; i++) {

            int sal = employeeArray[i].getSalary();
            totalSal += sal;

        }
        average = totalSal/entryCounter;


        //print records to console
            for(int j = 0; j < entryCounter; j++) {

                Employee emp = employeeArray[j];
                int salaryCheck = employeeArray[j].getSalary();

                if(salaryCheck > average) {
                    aboveAverage = true;
                } else {
                    aboveAverage = false;
                }

                if(entryCounter == 1) {

                    System.out.println(emp.toString() + "\nThe salary is neither below nor above average being the only salary entered");


                } else if(!aboveAverage) {

                    System.out.println(emp.toString() + "\nSalary is not above average");

                } else {

                    System.out.println(emp.toString() + "\nSalary is above average");


                }
        }
    }
}
