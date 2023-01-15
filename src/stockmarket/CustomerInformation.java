package stockmarket;

public class CustomerInformation {
    String personName;
    double balance;
    int quantity;
    double invest;
    String shareName;
    double buyerSharePrice;

    public double getBuyerSharePrice() {
        return buyerSharePrice;
    }

    public void setBuyerSharePrice(double buyerSharePrice) {
        this.buyerSharePrice = buyerSharePrice;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getInvest() {
        return invest;
    }

    public void setInvest(double invest) {
        this.invest = invest;
    }

    public String getShareName() {
        return shareName;
    }

    public void setShareName(String shareName) {
        this.shareName = shareName;
    }
}
