/*
This class is an exception class for if the SSNumber has invalid characters
 */
public class SNNCharacterException extends Exception {

    //constructor to send message to super
    SNNCharacterException(String message) {
        super(message);
    }

}
