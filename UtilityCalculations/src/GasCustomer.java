/*
This class encapsulates the information for a gas customer and extends the utility customer class.
 */

import java.text.NumberFormat;
import java.util.Locale;

public class GasCustomer extends UtilityCustomer {

    //double for cubicMetersUsed
    private double cubicMetersUsed;

    //constant double for price of gas
    private final double priceOfGasPCM = 2.75;

    //constructor that sets cubicMetersUsed and accountNumber variables
    GasCustomer(double cubicMetersUsed, int accountNumber) {

        super(accountNumber);
        this.cubicMetersUsed = cubicMetersUsed;

    }

    //accessor method that returns cubicMetersUsed
    public double getCubicMetersUsed() {

        return cubicMetersUsed;

    }

    //mutator method that sets cubicMetersUsed
    public void setCubicMetersUsed(double cubicMetersUsed) {

        this.cubicMetersUsed = cubicMetersUsed;
    }

    //public since it is public in superclass or change both to private
    public double calculateBill () {

        double total;
        total = cubicMetersUsed+priceOfGasPCM;

        return total;

    }

    //toString method that returns the cubicMetersUsed variable and account number as a nicely formatted string
    public String toString() {

        String finalStr = "";
        double total = calculateBill();
        String totalPriceStr;

        String acctNum = super.toString();

        NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.US);
        totalPriceStr = formatter.format(total);

        finalStr = acctNum + "\nThe amount of gas used: " + cubicMetersUsed + " Cubic Meters" + "\nThe total price is: " + totalPriceStr;

        return finalStr;

    }
}
