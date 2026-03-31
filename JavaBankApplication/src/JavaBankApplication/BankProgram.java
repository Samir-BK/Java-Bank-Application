package JavaBankApplication;

import java.util.Scanner;
import java.util.ArrayList;

public class BankProgram {
	private static Scanner input = new Scanner(System.in);
	private static ArrayList<Account> accountList = new ArrayList<Account>();

	// *** DO NOT change anything in the main method ***
	public static void main(String[] args) {
		int choice = -1;

		while (choice != 0) {
			displayMenu();
			try {
				choice = Integer.parseInt(input.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("Invalid input. Please enter a valid number.");
				choice = -1;
			} catch (Exception e) {
				System.out.println("No input available. Exiting.");
				choice = 0;
			}

			switch (choice) {
				case 1:
					listAccounts();
					break;
				case 2:
					addAccount();
					break;
				case 3:
					depositMoney();
					break;
				case 4:
					withdrawMoney();
					break;
				case 5:
					deleteAccount();
					break;
			}
		}

		System.out.println("\nThe program ends now. Bye!");
		input.close();
	}

	private static void displayMenu() {
		String line = "-----------------------------------------------------"
				+ "---------------------------------------------------------------";
		System.out.println(line);
		System.out.print(" 0 = Quit | 1 = List accounts | 2 = Add an account | " +
				"3 = Deposit money | 4 = Withdraw money | 5 = Delete an account \n");
		System.out.println(line);
		System.out.print("Enter your choice: ");
	}

	// *** NB! Edit only the methods below. DO NOT add any other methods! ***

	private static void listAccounts() {
		System.out.println("\n*** Account list ***\n");
		for (Account acc : accountList) {
			System.out.printf("Number: %s | Balance: %.2f euros\n", acc.getAccountNumber(), acc.getBalance());
		}
	}

	private static void addAccount() {
		System.out.print("\n*** Add an account ***\n");
		System.out.print("Enter account number: ");
		String accNum = input.nextLine();
		System.out.println();
		if (findAccount(accNum) != null) {
			System.out.println("Account not created. Account 2222 exists already!");
			return;
		}
		accountList.add(new Account(accNum));
		System.out.println("Account created successfully!");
	}

	// Finds an account in accountList by given account number.
	// Returns either a reference to the account object
	// OR null if the account is not found in accountList.
	private static Account findAccount(String accountNumber) {
		for (Account acc : accountList) {
			if (acc.getAccountNumber().equals(accountNumber)) {
				return acc;
			}
		}
		return null;
	}

	private static void depositMoney() {
		System.out.println("\n*** Deposit money to an account ***\n");
		System.out.print("Enter account number: ");
		String accNum = input.nextLine();
		Account acc = findAccount(accNum);
		if (acc == null) {
			System.out.println("Account " + accNum + " does not exist!");
			return;
		}
		System.out.print("Enter the amount to be deposited: ");
		try {
			double amt = Double.parseDouble(input.nextLine());
			if (amt < 0) {
				System.out.println("Cannot deposit a negative amount!");
				return;
			}
			acc.deposit(amt);
			System.out.println("Deposit completed successfully!");
		} catch (NumberFormatException e) {
			System.out.println("Invalid amount. Please enter a valid number.");
		}
	}

	private static void withdrawMoney() {
		System.out.print("\n*** Withdraw money from an account ***\n");
		System.out.print("Enter account number: ");
		String accNum = input.nextLine();
		Account acc = findAccount(accNum);
		if (acc == null) {
			System.out.println("Account " + accNum + " does not exist!");
			return;
		}
		System.out.print("Enter the amount to be withdrawn: ");
		try {
			double amt = Double.parseDouble(input.nextLine());
			if (amt < 0) {
				System.out.println("Cannot withdraw negative amount");
				return;
			}
			if (acc.withdraw(amt)) {
				System.out.println("Withdrawal completed successfully!");
			} else {
				System.out.println("Withdrawal not completed. Available balance is too low.");
			}
		} catch (NumberFormatException e) {
			System.out.println("Invalid amount. Please enter a valid number.");
		}
	}

	private static void deleteAccount() {
		System.out.print("\n*** Delete an account ***\n");
		System.out.print("Enter account number: ");
		String accNum = input.nextLine();
		Account acc = findAccount(accNum);
		if (acc == null) {
			System.out.println("Nothing deleted. Account " + accNum + " does not exist!");
			return;
		}
		accountList.remove(acc);
		System.out.println("Account deleted successfully!");
	}

}
// End
