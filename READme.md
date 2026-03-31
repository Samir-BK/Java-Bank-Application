# 🏦 Java Bank Application

A simple console-based banking application built in Java. It allows users to manage bank accounts through an interactive text menu — create accounts, deposit and withdraw money, and delete accounts.

---

## Features

- List all existing accounts with their balances
- Add a new bank account (with duplicate detection)
- Deposit money into an account
- Withdraw money from an account (with balance validation)
- Delete an account
- Input validation and error handling throughout

---

## Project Structure

```
JavaBankApplication/
├── BankProgram.java   # Main program — menu loop and user interaction
└── Account.java       # Account model — stores account number and balance
```

> `Account.java` must implement `getAccountNumber()`, `getBalance()`, `deposit(double)`, and `withdraw(double)`.

---

## Getting Started

### Prerequisites

- Java JDK 8 or higher

### Compile

```bash
javac JavaBankApplication/*.java
```

### Run

```bash
java JavaBankApplication.BankProgram
```

---

## Usage

When the program starts, you'll see a menu like this:

```
-------------------------------------------------------------------------------------
 0 = Quit | 1 = List accounts | 2 = Add an account | 3 = Deposit money | 4 = Withdraw money | 5 = Delete an account
-------------------------------------------------------------------------------------
Enter your choice:
```

| Option | Action                         |
| ------ | ------------------------------ |
| `0`    | Quit the program               |
| `1`    | List all accounts and balances |
| `2`    | Add a new account              |
| `3`    | Deposit money to an account    |
| `4`    | Withdraw money from an account |
| `5`    | Delete an account              |

---

## Example Session

```
Enter your choice: 2
*** Add an account ***
Enter account number: 1001
Account created successfully!

Enter your choice: 3
*** Deposit money to an account ***
Enter account number: 1001
Enter the amount to be deposited: 500
Deposit completed successfully!

Enter your choice: 1
*** Account list ***
Number: 1001 | Balance: 500.00 euros
```

---

## Notes

- Account numbers are stored as strings to support various formats.
- Withdrawals are rejected if the account balance is insufficient.
- Negative deposit and withdrawal amounts are not allowed.
- Duplicate account numbers are not permitted.
