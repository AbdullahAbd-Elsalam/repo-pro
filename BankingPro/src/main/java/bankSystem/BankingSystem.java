package bankSystem;

import java.util.Scanner;

public class BankingSystem {

    public static void main(String[] args) throws InvalidAmountException, InvalidFundsException {
        // Create a BankAccount object
        BankAccount account = new BankAccount("John Doe", 1000.0);

        // Use a Scanner for user input
        Scanner scanner = new Scanner(System.in);
        String option="";
        // for test number of operation that user you want to do
        boolean flag=true;
        try {
            do {
                // Main menu

                    System.out.println("\n= Banking System Menu ");
                    System.out.println("1. Deposit");
                    System.out.println("2. Withdraw");
                    System.out.println("3. Check Balance");
                    System.out.println("4. Calculate Interest");
                    System.out.println("5. Exit");
                    System.out.print("Enter your choice: ");

                    int choice = scanner.nextInt();

                    switch (choice) {
                        case 1:
                            System.out.print("Enter deposit amount: $");
                            double depositAmount = scanner.nextDouble();
                            account.deposit(depositAmount);
                            break;
                        case 2:
                            System.out.print("Enter withdrawal amount: $");
                            double withdrawalAmount = scanner.nextDouble();
                            account.withdraw(withdrawalAmount);
                            break;
                        case 3:
                            account.checkBalance();
                            break;
                        case 4:
                            double accountBalance = scanner.nextDouble();
                            double interest = account.calculateInterest(account.calculateInterest(accountBalance));
                            System.out.println("Interest earned: $" + interest);
                            break;
                        case 5:
                            System.out.println("Exiting the Banking System. Thank you!");
                            System.exit(0);
                            break;
                        default:
                            System.out.println("Invalid choice. Please enter a number between 1 and 5.");
                    }

                System.out.println("do you want to do another operation (YES/NO)");
                 option= scanner.next();

                 if(option.equalsIgnoreCase("yes"))
                 {
                     flag=true;
                 }else {

                     flag=false;
                 }
            }while (flag==true);
        }catch(Exception e){
            e.printStackTrace();

        }
    }
}
