package javaProject.methods.FinancialElements;
import javaProject.methods.FinancialElements.Deposit;
import javaProject.methods.FinancialElements.Withdraw;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class ManageFinances {

    public static float accountBalance;
    private static ArrayList<Float> transactionList = new ArrayList<Float>();
    private static ArrayList<Object> incomeList = new ArrayList<Object>();
    private static ArrayList<Object> expenseList = new ArrayList<Object>();
    static boolean running = true;

    public void editFinances() {
        while (running) {
            Scanner myObj = new Scanner(System.in);  // Create a Scanner object
            System.out.println("Enter income or expense:");
            String input = myObj.nextLine();

            // Checks if user input is deposit
            if (Objects.equals(input, "d")) {
                // creates a new instance of income
                Deposit Value = new Deposit();
                System.out.println("Enter deposit amount:");
                String depositString = myObj.nextLine();
                int depositAmount = Integer.parseInt(depositString);
                //adds the current variable to the transaction list
                transactionList.add(Value.generateDeposit(depositAmount, accountBalance));
                //adds the new income to account balance
                accountBalance += Value.updateAccountTotal(depositAmount, accountBalance);
            }
            //checks if user input is equal to withdraw
            else if (Objects.equals(input, "w")) {
                Withdraw Value = new Withdraw();
                System.out.println("Enter withdraw amount:");
                String withdrawString = myObj.nextLine();
                int withdrawAmount = Integer.parseInt(withdrawString);
                //adds the current variable to the transaction list
                transactionList.add(Value.generateWithdraw(withdrawAmount, accountBalance));
                //subtracts the expense from account balance
                //accountBalance += Value.updateAccountTotal(withdrawAmount, accountBalance);
            }
            //check if input is income
            else if (Objects.equals(input, "i")) {
                Income Value = new Income();
                System.out.println("Enter Income name:");
                String incomeNameString = myObj.nextLine();
                System.out.println("Enter Income amount:");
                String incomeAmountString = myObj.nextLine();
                int incomeAmount = Integer.parseInt(incomeAmountString);
                System.out.println("Enter how many times you will be paid:");
                String incomePaymentString = myObj.nextLine();
                int incomePayments = Integer.parseInt(incomePaymentString);
                System.out.println("Enter how many long you will be paid:");
                String incomeTimeString = myObj.nextLine();
                int incomeTime = Integer.parseInt(incomeTimeString);
                incomeList.add(Value.IncomeSource(incomeNameString, incomeAmount, incomePayments, incomeTime));
            }
            //check if input is expense
            else if (Objects.equals(input, "e")) {
                Expense Value = new Expense();
                System.out.println("Enter Expense name:");
                String expenseNameString = myObj.nextLine();
                System.out.println("Enter expense amount:");
                String expenseAmountString = myObj.nextLine();
                int expenseAmount = Integer.parseInt(expenseAmountString);
                System.out.println("Enter how many payments will you make:");
                String expensePaymentString = myObj.nextLine();
                int expensePayments = Integer.parseInt(expensePaymentString);
                System.out.println("Enter how many long you will make payments:");
                String expenseTimeString = myObj.nextLine();
                int expenseTime = Integer.parseInt(expenseTimeString);
                expenseList.add(Value.ExpenseSource(expenseNameString, expenseAmount, expensePayments, expenseTime));
            }
            else if (Objects.equals(input, "b")) {

            }
            //exits program if no condition is true
            else{
                System.out.println(accountBalance);
                System.out.println(transactionList);
                System.out.println(incomeList);
                System.out.println(expenseList);
                running = false;
            }

        }
    }
}