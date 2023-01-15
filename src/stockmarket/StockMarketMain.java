package stockmarket;

import java.util.Scanner;

public class StockMarketMain {
    public static final int BUY = 1;
    public static final int SELL = 2;
    public static final int DEBIT = 3;
    public static final int DISPLAY = 4;
    public static final int EXIT = 5;

    public static void main(String[] args) {
        System.out.println("::------- WELCOME STOCK MARKET ---------::");
        StockPortfolio stockPortfolio = new StockPortfolio();
        Scanner scan = new Scanner(System.in);
        while (true){
            System.out.println("Start Stock Market enter positive number 1 to 9");
            if (scan.nextInt() == 0) {
                System.out.println("Enter 1 to processed, to exit press 0 : ");
                while (true) {
                    int choice = (scan.nextInt() > 0) ? stockPortfolio.calculateStock() : 0;
                    if (choice == 0) {
                        System.out.println("Thank You! Terminated Process");
                        break;
                    }
                }
            } else {
                stockPortfolio.customerData();
                while (true) {
                    int index;
                    System.out.println("ENTER 1] BUY 2] SELL 3] DEBIT 4] WATCHLIST 5] EXIT");
                    switch (scan.nextInt()) {
                        case BUY:
                            stockPortfolio.stockReport();
                            index = stockPortfolio.getStockObj();
                            stockPortfolio.buy(index);
                            break;
                        case SELL:
                            stockPortfolio.printHistory();
                            index = stockPortfolio.getCustomerBuySellObj();
                            stockPortfolio.sell(index);
                            break;
                        case DEBIT:
                            stockPortfolio.debit();
                            break;
                        case DISPLAY:
                            stockPortfolio.printHistory();
                            break;
                        case EXIT:
                            System.out.println("thank you ! visit again ");
                            System.exit(0);
                        default:
                            System.out.println("INVALID NUMBER");
                    }
                }
            }
        }
    }
}
