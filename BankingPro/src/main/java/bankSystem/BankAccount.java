package bankSystem;
// BankAccount class with methods for deposit, withdrawal, and balance inquiry
public class BankAccount  implements InterestCalculator{

    // define customer username and accountBalance for him
    private  String customerName;
    private double accountBalance;

    // define a parameterize  Constructor that initial cust_name and and initial balance
    public BankAccount(String customerName, double initialBalance) {
        this.customerName = customerName;
        this.accountBalance = initialBalance;
    }

    // Deposit method
    public void deposit(double amount) throws InvalidAmountException {
        if (amount > 0) {
            accountBalance += amount;
            System.out.println("Deposit successful. New balance: $" + accountBalance);
        } else {
            // thow exception
            throw  new InvalidAmountException("amount is less than or equal zero");
        }
    }

    // Withdrawal method
    public void withdraw(double amount) throws InvalidFundsException {
        if (amount > 0 && amount <= accountBalance) {
            accountBalance -= amount;
            System.out.println("Withdrawal successful. New balance: $" + accountBalance);
        } else {
            throw  new InvalidFundsException("amount is greater than balance");
        }
    }

    // Balance inquiry method
    public void checkBalance() {
        System.out.println("Current balance: $" + accountBalance);
    }

    // Implementation of calculateInterest method from InterestCalculator interface
    @Override
    public double calculateInterest(double balance) {
        // Simple interest calculation (5%)
        return balance * 0.08;
    }
}
