package bankSystem;

public class InvalidFundsException extends Throwable {
    public InvalidFundsException(String  msg) {
        System.out.println(msg);
    }
}
