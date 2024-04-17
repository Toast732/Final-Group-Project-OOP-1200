package javaProject.methods;
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
            if (Objects.equals(input, "i")) {
                // creates a new instance of income
                Income Value = new Income();
                System.out.println("Enter income amount");
                String incomeString = myObj.nextLine();
                int incomeAmount = Integer.parseInt(incomeString);
                //adds the current variable to the transaction list
                transactionList.add(Value.generateIncome(incomeAmount, accountBalance));
                //adds the new income to account balance
                accountBalance += Value.updateAccountTotal(incomeAmount, accountBalance);
            }
            //checks if user input is equal to expense
            else if (Objects.equals(input, "e")) {
                Expense Value = new Expense();
                System.out.println("Enter expense amount");
                String expenseString = myObj.nextLine();
                int expenseAmount = Integer.parseInt(expenseString);
                //adds the current variable to the transaction list
                transactionList.add(Value.generateExpense(expenseAmount, accountBalance));
                //subtracts the expense from account balance
                accountBalance += Value.updateAccountTotal(expenseAmount, accountBalance);
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