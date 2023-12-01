package bankSystem;

public class InvalidAmountException extends Throwable {
    public InvalidAmountException(String s) {
        System.out.println(s);
    }
}
