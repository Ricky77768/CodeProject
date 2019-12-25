package Old_Work;

import java.util.Scanner;

public class vending_machine {
	/** documentations here (limits/functions etc) */
	/* comments here */
	public static void main(String[] args) {

		int S1, S2;
		double P1, P2;
		S1 = 50;
		S2 = 20;
		P1 = 2;
		P2 = 4;

		Scanner reader = new Scanner(System.in);

		for (int time = 0; time < 100; time++) {
			double price = 0;

			System.out.println("Please insert an amount of money: ");
			double money = reader.nextDouble();
			// Need to fix error when input contains characters

			System.out.println("\nItem\tPrice\tStock");
			System.out.println("Coke(1)\t" + P1 + "\t" + S1);
			System.out.println("Milk(2)\t" + P2 + "\t" + S2);

			System.out.println("Please select an item: ");
			int item = reader.nextInt();
			System.out.println("Please select an amount: ");
			int amount = reader.nextInt();

			if (item == 1) {
				if (S1 >= amount) {
					System.out.println("You are buying " + amount + " bottles of coke");
					price = P1 * amount;
					S1 = S1 - amount;
				} else {
					System.out.println("Not Enough Stock");
				}
			}

			else if (item == 2) {
				if (S2 >= amount) {
					System.out.println("You are buying " + amount + " bottles of milk");
					price = P2 * amount;
					S2 = S2 - amount;
				} else {
					System.out.println("Not Enough Stock");
				}
			} else {
				System.out.println("Invalid Item");
			}

			System.out.println("The price will be: " + price + " dollars");

			double change = money - price;

			while (change < 0) {
				System.out.println("Not enough money, please input " + -change + " dollar(s): ");
				money = reader.nextDouble();
				change = money + change;

			}
			System.out.println("Your Purchase is successful, you are given " + change + " dollars worth of change");
			System.out.println("-----------------------------------------");

		}
		reader.close();
	}
}
