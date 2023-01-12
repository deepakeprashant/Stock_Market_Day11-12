package stockmarket;

import java.util.Scanner;

public class StockMarketMain {
    public static void main(String[] args) {
        System.out.println("::------- WELCOME STOCK MARKET ---------::");
        StockPortfolio stockPortfolio = new StockPortfolio();
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter 1 to processed, to exit press 0 : ");
        while (true){
            int choice =(scan.nextInt()>0)? stockPortfolio.calculateStock(): 0;
            if (choice==0){
                System.out.println("Thank You! Terminated Process");
                return;
            }
        }
    }
}
