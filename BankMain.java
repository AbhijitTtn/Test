package colletions;

import static java.lang.System.exit;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

enum Acc_Type {
	SAVINGS, CURRENT;
}

class Bank {
	int accno;
	String name;
	int acc_type;
	long balance;
	int years;
	Acc_Type a1 = Acc_Type.SAVINGS;
	Acc_Type a2 = Acc_Type.CURRENT;

	Bank() {
		balance = 500;
	}

	Scanner sc = new Scanner(System.in);

	public void getDetails() {
		try {
			BufferedWriter f_writer = new BufferedWriter(
					new FileWriter(("/home/abhijit/Desktop/Java collections/bank.txt")));
			// Added bank.txt where i store the details
			System.out.print("Enter Account No: ");
			accno = sc.nextInt();
			String s = Integer.toString(accno);
			f_writer.write("Account Number: " + s);
			System.out.print("Enter Account type :\n1.SAVINGS\n2.CURRENT\n ");
			acc_type = sc.nextInt();
			String t = Integer.toString(acc_type);
			f_writer.write("Account Type: " + t);
			System.out.print("Enter Name: ");
			name = sc.next();
			f_writer.write("Account Holder Name: " + name);
			System.out.print("Enter Balance: ");
			balance = balance + sc.nextLong();
			String bal = Long.toString(balance);
			f_writer.write("Account Balance: " + bal);
			System.out.println("Enter number of years to check interest");
			years = sc.nextInt();
			String y = Integer.toString(years);
			// f_writer.write(y);
			f_writer.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void displayDetails() {
		System.out.println("Name of account holder: " + name);
		System.out.println("Account no.: " + accno);
		if (acc_type == 1)
			System.out.println("Account type: " + a1);
		else if (acc_type == 2)
			System.out.println("Account type: " + a2);
		else
			System.out.println("Your have entered Invalid Choice");
		System.out.println("Balance: " + balance);
	}

	public void deposit() {
		long amt;
		System.out.println("Enter the amount you want to deposit: ");
		amt = sc.nextLong();
		balance = balance + amt;
	}

	public void withdrawal() {
		long amt;
		System.out.println("Enter the amount you want to withdraw: ");
		amt = sc.nextLong();
		try {
			if (balance >= amt) {
				balance = balance - amt;
				System.out.println("Balance after withdrawal: " + balance);
			} else {
				System.out.println("Insufficient Amount");
			}
		} catch (Exception e) {
			System.out.println("Throw InsufficientAmountException " + amt + "\nTransaction failed...!!");
		}
	}

}

class SBI extends Bank {
	double rate = 0.10;

	void sbi() throws IOException {
		do {
			System.out.println("\n1.Create Account\n2.Deposit Money\n3.Withdraw Money\n4.Display Details\n5.Exit");
			int ch = sc.nextInt();
			switch (ch) {
			case 1:
				getDetails();
				break;
			case 2:
				deposit();
				break;
			case 3:
				withdrawal();
				break;
			case 4:
				displayDetails();
				double interest = balance * rate * years;
				System.out.println("For " + years + " years you will get " + rate * 100 + " % rate "
						+ "\nYour will receive a interest of " + interest);

				break;
			case 5:
				System.out.println("Successfully Exit");
				exit(0);
			}
		} while (true);
	}
}

class BOI extends Bank {
	double rate = 0.12;

	void boi() {
		do {
			System.out.println("\n1.Create Account\n2.Deposit Money\n3.Withdraw Money\n4.Display Details\n5.Exit");
			int ch = sc.nextInt();
			switch (ch) {
			case 1:
				getDetails();
				break;
			case 2:
				deposit();
				break;
			case 3:
				withdrawal();
				break;
			case 4:
				displayDetails();
				double interest = balance * rate * years;
				System.out.println("For " + years + " years you will get " + rate * 100 + " % rate "
						+ "\nYour will receive a interest of " + interest);
				break;
			case 5:
				System.out.println("Successfully Exit");
				exit(0);
			}
		} while (true);
	}
}

class ICICI extends Bank {
	double rate = 0.15;

	void icici() {
		do {
			System.out.println("\n1.Create Account\n2.Deposit Money\n3.Withdraw Money\n4.Display Details\n5.Exit");
			int ch = sc.nextInt();
			switch (ch) {
			case 1:
				getDetails();
				break;
			case 2:
				deposit();
				break;
			case 3:
				withdrawal();
				break;
			case 4:
				displayDetails();
				double interest = balance * rate * years;
				System.out.println("For " + years + " years you will get " + rate * 100 + " % rate "
						+ "\nYour will receive a interest of " + interest);
				break;
			case 5:
				System.out.println("Successfully Exit");
				exit(0);
			}
		} while (true);
	}
}

class BankMain {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		System.out.println("* Choose your bank * \n1.SBI\n2.BOI\n3.ICICI");
		int ch = sc.nextInt();
		switch (ch) {
		case 1:
			SBI ob = new SBI();
			ob.sbi();
			break;
		case 2:
			BOI ob2 = new BOI();
			ob2.boi();
		case 3:
			ICICI ob3 = new ICICI();
			ob3.icici();
		}

	}
}
