/*
This class encapsulates the information needed for a electric customer and extends the Utility Customer class
 */

import java.text.NumberFormat;
import java.util.Locale;

public class ElectricCustomer extends UtilityCustomer {

    //declare variables and constants
    private double kWattHourUsed = 0;
    private final double FLAT_DELIV_FEE = 30.0;
    private final double PRICE_PER_KWATT_HOUR = 0.13;

    //constructor that takes KWattHoursUsed and AccountNumber as args
    public ElectricCustomer(double kWattHourUsed, int accountNumber) {

        super(accountNumber);
        this.kWattHourUsed = kWattHourUsed;

    }

    //getter method for KWattHoursUsed
    public double getKWHourUsed() {

        return kWattHourUsed;
    }

    //setter method for KWattHoursUsed
    public void setkWattHourUsed(double kWattHourUsed) {

        this.kWattHourUsed = kWattHourUsed;

    }

    //method to calculate the bill
    @Override
    public double calculateBill() {
        double total = 0;
        total = FLAT_DELIV_FEE + (kWattHourUsed*PRICE_PER_KWATT_HOUR);
        return total;
    }

    //converts customer information to a string and returns said string
    public String toString() {

        String finalStr = "";
        double total = calculateBill();
        String totalPriceStr;
        String acctNum = super.toString();
        NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.US);
        totalPriceStr = formatter.format(total);
        finalStr = acctNum + "\nThe amount of electricity used: " + kWattHourUsed + " Kilo-Watt Hours" + "\nThe total price is: " + totalPriceStr;
        return finalStr;

    }
}
