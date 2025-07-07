package mypackage;
/*
Please provide the information about the packages below.
Weight and price of package 1:
0,9 4,5
Weight and price of package 2:
0,33 1,75
Package 2 has a worse unit price!
Which package would you like to order?
1
How many packages would you like to order?
2
The total cost of 2 packages will be 9.0 euros.
*/

import java.util.Scanner;

public class UnitPriceCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Please provide the information about the packages below.");

        // Get info for package 1
        System.out.println("Weight and price of package 1:");
        double weight1 = sc.nextDouble();
        double price1 = sc.nextDouble();

        // Get info for package 2
        System.out.println("Weight and price of package 2:");
        double weight2 = sc.nextDouble();
        double price2 = sc.nextDouble();

        // Validate the inputs (weights and prices must be positive)
        if (weight1 <= 0 || price1 <= 0 || weight2 <= 0 || price2 <= 0) {
            System.out.println("Inputs are invalid.");
            sc.close();
            return;
        }

        // Calculate unit prices
        double unitPrice1 = price1 / weight1;
        double unitPrice2 = price2 / weight2;

        // Determine which package has a worse unit price (i.e. higher cost per kg)
        if (unitPrice1 > unitPrice2) {
            System.out.println("Package 1 has a worse unit price!");
        } else if (unitPrice2 > unitPrice1) {
            System.out.println("Package 2 has a worse unit price!");
        } else {
            System.out.println("Both packages have the same unit price!");
        }

        // Ask the consumer which package to order
        System.out.println("Which package would you like to order?");
        int packageChoice = sc.nextInt();
        if (packageChoice != 1 && packageChoice != 2) {
            System.out.println("Inputs are invalid.");
            sc.close();
            return;
        }

        // Ask for the number of packages to order
        System.out.println("How many packages would you like to order?");
        int quantity = sc.nextInt();
        if (quantity <= 0) {
            System.out.println("Inputs are invalid.");
            sc.close();
            return;
        }

        // Calculate total cost based on the consumer’s choice
        double totalCost = 0;
        if (packageChoice == 1) {
            totalCost = quantity * price1;
        } else { // packageChoice == 2
            totalCost = quantity * price2;
        }

        System.out.println("The total cost of " + quantity + " packages will be " + totalCost + " euros.");
        sc.close();
    }
}
