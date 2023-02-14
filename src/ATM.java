import java.util.Scanner;

public class ATM extends Database{

    public void validateAccount(){
        Scanner sc = new Scanner(System.in);
        Message out = new Message();

        do {
            out.println("\nWelcome!");
            
            out.print("Please enter your account number: ");
            int accountNumber = sc.nextInt();
            
            out.print("Enter your PIN: ");
            int pinNumber = sc.nextInt();
            
            boolean validate = authenticateAccount(accountNumber, pinNumber);
            if(validate == false){
               out.println("Invalid Account Number/PIN...Please Try Again\n");
            //    validateAccount();
            }
            else{ displayMenu(); break; }
        } while (true);
    }

    public void displayMenu(){        
        Scanner sc = new Scanner(System.in);
        Message out = new Message();
 
        do {
            out.print("\nMain Menu: ");
            out.print("\n1 - View my balance\n2 - Withdraw cash\n3 - Deposit funds\n4 - Exit");
            
            out.print("\nEnter a choice: ");
            int userInput = sc.nextInt();
            
            switch(userInput){
                case 1: { balanceInquiry(); break;}
                case 2: { withdraw(); break;}
                case 3: { deposit(); break;}
                case 4: {
                    out.print("\nThank You!\n");
                    validateAccount();
                    break;
                }
                default: { out.print("\nInvalid Input...Please try again"); }   
            }                
        } while (true);
    }

    public void balanceInquiry(){
        Message out = new Message();
        double accountBalance = Double.valueOf(super.getBalance(super.getUserAccount()));
        out.println("Balance Information:");
        out.print("Available balance: ");
        out.displayDollarBalance(accountBalance);
        System.out.println();
    }

    public void withdraw(){
        Scanner sc = new Scanner(System.in);
        Message out = new Message();

        do {
            out.print("\nWithdrawal Amount:");
            out.println("\n1. $20 \n2. $40 \n3. $60 \n4. $100 \n5. $200\n6. Cancel");
            out.print("Enter choice: ");
            int userInput = sc.nextInt();

            // add balance checker
            if (userInput == 1){ super.debit(super.getUserAccount(), 20); break; }   
            else if (userInput == 2){ super.debit(super.getUserAccount(), 40); break; }
            else if (userInput == 3){ super.debit(super.getUserAccount(), 60); break; }
            else if (userInput == 4){ super.debit(super.getUserAccount(), 100); break; }
            else if (userInput == 5){ super.debit(super.getUserAccount(), 200); break; }           
            else if(userInput == 6){  out.println("\nCancelling transaction..."); break; }
            else{ out.println("Invalid input"); }
        } while (false);
    }

    public void deposit(){
        Scanner sc = new Scanner(System.in);
        Message out = new Message();

        do {
            out.print("\nPlease enter a deposit amount (or 0 to cancel): ");
            int userInput = sc.nextInt();

            if(userInput > 0) {                
                super.setBalance(super.getUserAccount(), userInput);
                out.println("Please insert a deposit envelope containing $" + userInput +".");
                out.println("Your envelope has been received.");
                break;
            }
            else { out.println("\nCancelling transaction..."); break; }
        } while (true);
    }
}
