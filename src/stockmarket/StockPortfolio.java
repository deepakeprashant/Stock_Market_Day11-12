package stockmarket;

import java.util.ArrayList;
import java.util.Scanner;

public class StockPortfolio {
    Scanner scan = new Scanner(System.in);
    ArrayList<Stock> stocksStorage = new ArrayList<>();
    Stock stock;
    double totalValueStock;

    public int calculateStock() {
        System.out.println("Enter number of stock you want");
        int numberOfStock = scan.nextInt();
        for (int i = 0; i < numberOfStock; i++) {
            System.out.println("Enter share name");
            String shareName = scan.next();
            System.out.println("Enter number of share");
            int numberOfShare = scan.nextInt();
            System.out.println("Enter share Price :");
            double sharePrice = scan.nextDouble();
            double valueOfEachStock = numberOfShare * sharePrice;
            stock = new Stock(shareName, numberOfShare, sharePrice, valueOfEachStock);
            stocksStorage.add(stock);
        }
        stockReport();
        debit();
        System.out.println("\nAdd new stock enter positive number ! Exit process enter 0");
        return 1;
    }

    private void stockReport() {
        totalValueStock = 0;
        System.out.println("Share Name | \tNumber of stock |\tStock Price |\tEach Value Of Stock");
        for (Stock stock : stocksStorage) {
            totalValueStock += stock.getValueOfEachStock();
            System.out.print(stock.getShareName() + "\t\t\t" + stock.getNumberOfShare() +
                    "\t\t" + stock.getSharePrice() + " INR. \t\t" + stock.getValueOfEachStock() + " INR");
            System.out.println();
        }
        System.out.println("\n\tTotal value of stock :- " + totalValueStock + " INR");
    }

    void debit() {
        System.out.println("Do you want Withdraw Money Enter 'y'");
        char choice = scan.next().charAt(0);
        if (choice == 'Y' || choice == 'y') {
            double withdrawAmount;
            System.out.print("Enter the amount you want to withdraw : ");
            withdrawAmount = scan.nextDouble();
            if (totalValueStock - withdrawAmount <= 0)
                System.out.println("Insufficient balance. Debit amount exceeded account balance. \n ");
            else if (withdrawAmount == 0) {
                System.out.println("Enter amount grater than zero to withdraw the amount. \n");
            } else {
                System.out.print("The amount of $" + withdrawAmount + " will be deducted form your Account. \n Press Y to proceed or N to cancel the process : ");
                char tempChar = scan.next().charAt(0);
                if ((tempChar == 'Y') || (tempChar == 'y')) {
                    totalValueStock = totalValueStock - withdrawAmount;
                    System.out.println("\n Amount of $" + withdrawAmount + " withdrawn from the Account. \n Thank you !!");
                    System.out.println("Remaining Balance is : $" + totalValueStock);
                } else {
                    System.out.println("Withdrawal process has been terminated, you're being redirected to main menu.\n");
                }
            }
        }
    }
}
