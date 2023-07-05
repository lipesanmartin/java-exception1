package exercise;

import java.util.Scanner;

import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter account data");
		System.out.print("Number: ");
		int number = Integer.parseInt(sc.nextLine());
		System.out.print("Holder: ");
		String name = sc.nextLine();
		System.out.print("Initial balance: ");
		double balance = Double.parseDouble(sc.nextLine());
		System.out.print("Withdraw limit: ");
		double limit = Double.parseDouble(sc.nextLine());
		
		Account account = new Account(number, name, balance, limit);
		
		System.out.println();
		try {
			System.out.print("Enter amount for withdraw: ");
			double withdraw = Double.parseDouble(sc.nextLine());
			account.withdraw(withdraw);
			System.out.println("New balance: " + String.format("%.2f", account.getBalance()));
		} catch (DomainException e) {
			System.out.println("Withdraw error: " + e.getMessage());
		} catch (RuntimeException e) {
			System.out.println("Unexpected error");
		}
		sc.close();
	}

}
