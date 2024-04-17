package javaProject.methods.FinancialElements;
import javaProject.methods.FinancialElements.Deposit;
import javaProject.methods.FinancialElements.Withdraw;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class ManageFinances {

    private static int accountBalance;
    private static ArrayList<Integer> transactionList = new ArrayList<Integer>();
    static boolean running = true;

    public void editFinances() {
        while (running) {
            Scanner myObj = new Scanner(System.in);  // Create a Scanner object
            System.out.println("Enter income or expense");
            String input = myObj.nextLine();

            // Checks if user input is income
            if (Objects.equals(input, "d")) {
                // creates a new instance of income
                Deposit Value = new Deposit();
                System.out.println("Enter deposit amount");
                String depositString = myObj.nextLine();
                int depositAmount = Integer.parseInt(depositString);
                //adds the current variable to the transaction list
                transactionList.add(Value.generateDeposit(depositAmount, accountBalance));
                //adds the new income to account balance
                accountBalance += Value.updateAccountTotal(depositAmount, accountBalance);
            }
            //checks if user input is equal to expense
            else if (Objects.equals(input, "w")) {
                Withdraw Value = new Withdraw();
                System.out.println("Enter withdraw amount");
                String withdrawString = myObj.nextLine();
                int withdrawAmount = Integer.parseInt(withdrawString);
                //adds the current variable to the transaction list
                transactionList.add(Value.generateWithdraw(withdrawAmount, accountBalance));
                //subtracts the expense from account balance
                accountBalance += Value.updateAccountTotal(withdrawAmount, accountBalance);
            }
            //exits program if neither condition is true
            else{
                System.out.println(accountBalance);
                System.out.println(transactionList);
                running = false;
            }

        }
    }
}