/*
This class is an exception class for if the SSNumber has invalid length
 */
public class SNNLengthException extends Exception {

    //constructor to send message to super
    SNNLengthException(String message) {
        super(message);
    }

}
