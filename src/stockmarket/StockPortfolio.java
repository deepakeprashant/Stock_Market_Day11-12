package stockmarket;

import java.util.ArrayList;
import java.util.Scanner;

public class StockPortfolio {
    Scanner scan = new Scanner(System.in);
    ArrayList<Stock> stocksStorage = new ArrayList<>();
    Stock stock;

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
        System.out.println("\nAdd new stock enter positive number ! Exit process enter 0");
        return 1;
    }

    void stockReport() {
        double totalValueStock=0;
        System.out.println("Share Name | \tNumber of stock |\tStock Price |\tEach Value Of Stock");
        for (Stock stock : stocksStorage) {
            totalValueStock += stock.getValueOfEachStock();

            System.out.print(stock.getShareName() + "\t\t\t" + stock.getNumberOfShare() +
                    "\t\t" + stock.getSharePrice() + " INR. \t\t" + stock.getValueOfEachStock() + " INR");
            System.out.println();
        }
        System.out.println("\n\tTotal value of stock :- "+totalValueStock+" INR");
    }
}
