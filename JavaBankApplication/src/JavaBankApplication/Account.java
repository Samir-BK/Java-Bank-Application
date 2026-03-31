package JavaBankApplication;

public class Account {
	private String accountNumber;
	private double balance = 0.0;

	public Account(String accountNumber) {
		this.accountNumber = accountNumber;
		this.balance = 0.0;
	}

	public void deposit(double amount) {
		balance += amount;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public double getBalance() {
		return balance;
	}

	public boolean withdraw(double amount) {
		if (amount <= balance) {
			balance -= amount;
			return true;
		}
		return false;
	}

}
// End