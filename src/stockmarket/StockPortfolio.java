package stockmarket;

import java.util.ArrayList;
import java.util.Scanner;

public class StockPortfolio {
    Scanner scan = new Scanner(System.in);
    ArrayList<Stock> stocksStorage = new ArrayList<>();
    ArrayList<CustomerInformation> customerObj = new ArrayList<>();
    CustomerInformation customers = new CustomerInformation();
    Stock stock;
    double totalValueStock;
    double totalInvest, originalBalance, totalQuantity;

    public int getStockObj() {
        System.out.println("Enter Share Name");
        String shareName = scan.next();
        for (int index = 0; index < stocksStorage.size(); index++) {
            if (shareName.equals(stocksStorage.get(index).shareName)) {
                return index;
            }
        }
        return -1;
    }

    public int getCustomerBuySellObj() {
        System.out.println("Enter Share Name");
        String shareName = scan.next();
        for (int index = 0; index < customerObj.size(); index++) {
            if (shareName.equals(customerObj.get(index).getShareName())) {
                return index;
            }
        }
        return -1;
    }

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

    public void customerData() {
        System.out.println("Enter Your Name");
        String name = scan.next();
        customers.setPersonName(name);
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

    public void buy(int index) {
        if (index != -1) {
            System.out.println("Enter Quantity of stock");
            int quantity = scan.nextInt();
            if (quantity <= stocksStorage.get(index).getNumberOfShare()) {
                double amount = quantity * stocksStorage.get(index).sharePrice;
                if (customers.balance >= amount) {
                    totalQuantity = quantity + customers.getQuantity();
                    customers.quantity = quantity;
                    customers.balance = customers.getBalance() - amount;
                    customers.shareName = stocksStorage.get(index).shareName;
                    stocksStorage.get(index).setNumberOfShare(stocksStorage.get(index).getNumberOfShare() - quantity);
                    customers.invest = amount;
                    totalInvest = totalInvest + amount;
                    customers.buyerSharePrice = stocksStorage.get(index).sharePrice;
                    customerObj.add(customers);
                    System.out.println("Added successfully share");
                    return;
                }
                System.out.println("Insufficient balance . Current Balance " + customers.getBalance() +
                        "\nRequired Amount :- " + amount);
                System.out.println("Add Account Balance");
                originalBalance = scan.nextInt();
                customers.setBalance(originalBalance);
                return;
            }
            System.out.println("Sorry Quantity is High! current share Available" + stocksStorage.get(index).getNumberOfShare());
            return;
        }
        System.out.println("Shares Not Available");
    }

    public void sell(int index) {
        if (index != -1) {
            System.out.println("Enter Quantity of stock");
            int quantity = scan.nextInt();
            double luck;
            if (quantity <= customerObj.get(index).getQuantity()) {
                int random = (int) Math.random() * 10;
                if (random <= 7 ) {
                    luck = quantity * (customerObj.get(index).buyerSharePrice * random);
                    System.out.println("Profit");
                } else {
                    luck = quantity * (customerObj.get(index).buyerSharePrice / random);
                    System.out.println("Loss");
                }
                customers.setQuantity(customerObj.get(index).quantity - quantity);
                customers.setInvest(customerObj.get(index).invest - (quantity * customerObj.get(index).buyerSharePrice));
                customers.setBalance(customers.getBalance() + luck);
                totalInvest = totalInvest - quantity * customerObj.get(index).buyerSharePrice;
                return;
            }
            System.out.println("Sorry Quantity is High! current share Available" + stocksStorage.get(index).getNumberOfShare());
            return;
        }
        System.out.println("Shares Not Available");
    }

    public void printHistory() {
        int i = 1;
        System.out.println("User:- " + customerObj.get(0).getPersonName() + "\t\tOriginal Bal:- " + originalBalance);
        System.out.println("Share Name\t Buy Quantity\tShare Price\t Invest Money");
        for (CustomerInformation custmObj : customerObj) {
            System.out.print(i + "] " + custmObj.shareName + "\t\t\t" + custmObj.quantity + "\t" + custmObj.buyerSharePrice + "\t" +
                    custmObj.invest);
            System.out.println("\n\tCurrent Bal :- " + custmObj.balance);
            i++;
        }
        System.out.println("\tTotal Invest :- " + totalInvest);
    }
}
