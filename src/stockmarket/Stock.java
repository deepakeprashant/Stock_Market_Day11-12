package stockmarket;

public class Stock {
    String shareName;
    int numberOfShare;
    double sharePrice;
    double valueOfEachStock;

    public double getValueOfEachStock() {
        return valueOfEachStock;
    }

    public void setValueOfEachStock(double valueOfEachStock) {
        this.valueOfEachStock = valueOfEachStock;
    }

    Stock(String shareName, int numberOfShare, double sharePrice, double valueOfEachStock) {
        this.shareName = shareName;
        this.numberOfShare = numberOfShare;
        this.sharePrice = sharePrice;
        this.valueOfEachStock = valueOfEachStock;
    }

    public String getShareName() {
        return shareName;
    }

    public void setShareName(String shareName) {
        this.shareName = shareName;
    }

    public int getNumberOfShare() {
        return numberOfShare;
    }

    public void setNumberOfShare(int numberOfShare) {
        this.numberOfShare = numberOfShare;
    }

    public double getSharePrice() {
        return sharePrice;
    }

    public void setSharePrice(double sharePrice) {
        this.sharePrice = sharePrice;
    }
}
