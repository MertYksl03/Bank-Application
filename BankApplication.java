/* Mert YÜKSEL
 * 220315044
 */

import java.util.Scanner;

public class BankApplication{
    static final String USERNAME="user";
    static final String PASSWORD="1234";
    static double accountBalance=0;

    public static void main(String[] args)
    {
        System.out.println("---Welcome to the Bank Application--- ");
        System.out.println("Please enter your Username and Password to continue");
        Scanner input = new Scanner(System.in);
        String username;
        String password;

        while (true)
        {
            System.out.print("Username: ");
            username= input.nextLine();
            System.out.print("\n");
            System.out.print("Password: ");
            password= input.nextLine();
            System.out.print("\n");
            boolean isLoginSuccesfull= authenticeUser(username, password);
            if (isLoginSuccesfull){
                System.out.println("Login succesfull. Welcome "+ username);
                break;
            }
            else {
                System.out.println("Invalid username or password. Please try again. ");
            }
        }
        while (true)
        {
            printMenu();
            //this (if) ensures the input is a byte. 
            if (input.hasNextByte()){
                byte choice = input.nextByte();
                switch (choice) {
                    case 1:
                        depositMoney(input);
                        break;
                    case 2:
                        withdrawMoney(input);
                        break;
                    case 3:
                        checkBalance();
                        break;
                    case 4:
                        break;
                    default:
                        System.out.println("\nInvalid choice. Please enter a valid option. ");
                        break;
                }
                // to exit the program 
                if (choice==4){
                    break;
                }
            }
            else {
                input.next();
                System.out.println("\nPlease enter a valid option. ");
            }
        }
        System.out.println("Program ended. Have a nice day. ");
        input.close();
    }
    
    public static boolean authenticeUser(String username, String password)
    {
        if (USERNAME.equals(username) && PASSWORD.equals(password)){
            return true;
        }
        else {
            return false;
        }
    }
    public static void printMenu()
    {
        System.out.println("\n--- Bank Application ---");
        System.out.println("1. Deposit Money");
        System.out.println("2. Withdraw Money");
        System.out.println("3. Check Account Balance");
        System.out.println("4. Exit");
        System.out.print("Your choice: ");

    }
    public static void depositMoney(Scanner input)
    {
        System.out.print("\nEnter the amount to deposit: ");
        //this while loop ensures that the user enters a valid number.
        while (true){
        if (input.hasNextDouble()){
    
            double deposit= input.nextDouble();

            //this part ensures that if the user enters a negative number, it will prevent the calculation from proceeding.
            if (deposit > 0){
            accountBalance+= deposit;
            System.out.println("\nDeposit succesful. New balance: " + accountBalance);
            }
            else{
            System.out.println("\nPLEASE ENTER A POSITIVE NUMBER. ");
            }
            break;
        }
        else {
            input.next();
            System.out.println("Please enter a number.");
        }
    }


    }
    public static void withdrawMoney(Scanner input)
    {
        System.out.print("\nEnter the amount of withdraw: ");
        while (true){
            if(input.hasNextDouble()){
                double withdraw= input.nextDouble();
                if (withdraw > 0){ 
                if (accountBalance>=withdraw){
                    accountBalance-=withdraw;
                    System.out.println("\nWithdraw succesful. Current balance: "+ accountBalance);
                }
                else{
                    System.out.println("\nINSUFFICENT BALANCE. The withdrawal amount cannot exceed the account balance. ");
                }
            }
            else {
                    System.out.println("\nPLEASE ENTER A POSITIVE NUMBER. ");
                }

            break;
            }
            else {
                input.next();
                System.out.println("Please enter a number. ");
            }
        }
    

    }
    public static void checkBalance()
    {
        System.out.println("\nCurrent Balance: " + accountBalance );
    }
    
}