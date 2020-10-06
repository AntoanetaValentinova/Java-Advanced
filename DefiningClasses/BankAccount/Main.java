package BankAccount;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();

        List<BankAccount> users = new ArrayList<>();
        while (!input.equals("End")) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];
            switch (command) {
                case "Create":
                    BankAccount bankAccount = new BankAccount();
                    users.add(bankAccount);
                    System.out.printf("Account ID%s created%n", bankAccount.getId());
                    break;
                case "Deposit":
                    int id = Integer.parseInt(tokens[1]);
                    double amount = Double.parseDouble(tokens[2]);
                    if (id <= users.size()) {
                        users.get(id - 1).deposit(amount);
                        System.out.printf("Deposited %.0f to ID%d%n", amount, id);
                    } else {
                        System.out.println("Account does not exist");
                    }
                    break;
                case "SetInterest":
                    double interest = Double.parseDouble(tokens[1]);
                    BankAccount.setInterestRate(interest);
                    break;
                case "GetInterest":
                    int idd = Integer.parseInt(tokens[1]);
                    double years = Double.parseDouble(tokens[2]);
                    if (idd <= users.size()) {
                        System.out.printf("%.2f%n",users.get(idd - 1).getInterest(years));
                    } else {
                        System.out.println("Account does not exist");
                    }
                    break;
            }
            input = scan.nextLine();
        }
    }
}
