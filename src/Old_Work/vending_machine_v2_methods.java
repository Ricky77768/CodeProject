package Old_Work;

import java.util.Scanner;

public class vending_machine_v2_methods {

	public static double cal_change(int[] amount, double[] price, double money_inserted) {
		double money_required = 0, change;
		for (int i = 0; i < 100; i++) {
			money_required = money_required + amount[i] * price[i];
		}
		change = money_inserted - money_required;
		return change;
	}

	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		double money = -1, required;
		int number = -1, amount = 1000, purchase_number = 0;
		String answer = " ";
		int[] item_name = new int[5];
		int[] item_stock = new int[5];
		double[] item_price = new double[5];
		int[] p_amount = new int[100];
		double[] p_item_price = new double[100];

		item_name[0] = 1;
		item_name[1] = 2;
		item_name[2] = 3;
		item_name[3] = 4;
		item_name[4] = 5;
		item_price[0] = 0.99;
		item_price[1] = 3.99;
		item_price[2] = 7.99;
		item_price[3] = 13.99;
		item_price[4] = 24.99;
		item_stock[0] = 50;
		item_stock[1] = 30;
		item_stock[2] = 15;
		item_stock[3] = 8;
		item_stock[4] = 3;

		System.out.println("Please input an amount of money:");
		while (money < 0) {
			money = reader.nextDouble();
			if (money < 0) {
				System.out.println("Positive amount of money only.");
			}
		}
		while (!answer.equals("NO")) {
			number = -1;
			amount = 1000;
			answer = " ";

			System.out.println("\nItem\tPrice\tStock");
			for (int i = 0; i < item_name.length; i++) {
				System.out.println(item_name[i] + "\t" + item_price[i] + "\t" + item_stock[i]);
			}

			System.out.println("Please choose an item number(1-5):");
			while (number < 1 || number > 5) {
				number = reader.nextInt();
				if (number < 1 || number > 5) {
					System.out.println("Invalid Item, please choose from item 1-5.");
				}
			}

			System.out.println("How many are you buying?");
			while (amount > item_stock[number - 1]) {
				amount = reader.nextInt();
				if (amount > item_stock[number - 1]) {
					System.out.println("Not enough stock (Only " + item_stock[number - 1] + " left)");
				}
			}

			item_stock[number - 1] = item_stock[number - 1] - amount;
			p_amount[purchase_number] = amount;
			p_item_price[purchase_number] = item_price[number - 1];
			System.out.println("Your purchase has been recorded, would you like to buy more?");
			System.out.println("Enter YES to continue, NO to calculate the price");

			while (!answer.equals("YES") && !answer.equals("NO")) {
				answer = reader.next();
				if (!answer.equals("YES") && !answer.equals("NO")) {
					System.out.println("Please answer with YES or NO");
				}
			}
			if (answer.equals("YES")) {
				purchase_number = purchase_number + 1;
			}
		}
		required = cal_change(p_amount, p_item_price, money);

		while (required < 0) {
			System.out.println("Please insert " + required * -1 + " more dollars to complete the purchase");
			money = reader.nextDouble();
			required = required + money;
		}

		System.out.println("\nPurchase successful, you are given " + required + " dollars worth of change.");
		reader.close();
	}
}