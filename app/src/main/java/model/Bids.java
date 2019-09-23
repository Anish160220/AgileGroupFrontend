package model;

public class Bids {
    private int bidId, userId,bidID;
    private String  bidImage, bidTitle;
    private int startingPrice, maxPrice,marketValue,bidAmount;
    private String endingDate;
    private String category;
    private int bidCount;
    private String status;


    public Bids(int startingPrice, int maxPrice, String endingDate) {
        this.startingPrice = startingPrice;
        this.maxPrice = maxPrice;
        this.endingDate = endingDate;
    }



    public Bids(int userId, String bidImage, String bidTitle, int startingPrice, int maxPrice, int marketValue, String endingDate, String category, int bidCount, String status) {
        this.userId = userId;
        this.bidImage = bidImage;
        this.bidTitle = bidTitle;
        this.startingPrice = startingPrice;
        this.maxPrice = maxPrice;
        this.marketValue = marketValue;
        this.endingDate = endingDate;
        this.category = category;
        this.bidCount = bidCount;
        this.status = status;
    }

    public int getBidID() {
        return bidID;
    }

    public void setBidID(int bidID) {
        this.bidID = bidID;
    }

    public int getBidId() {
        return bidId;
    }

    public void setBidId(int bidId) {
        this.bidId = bidId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getBidImage() {
        return bidImage;
    }

    public void setBidImage(String bidImage) {
        this.bidImage = bidImage;
    }

    public String getBidTitle() {
        return bidTitle;
    }

    public void setBidTitle(String bidTitle) {
        this.bidTitle = bidTitle;
    }

    public int getStartingPrice() {
        return startingPrice;
    }

    public void setStartingPrice(int startingPrice) {
        this.startingPrice = startingPrice;
    }

    public int getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(int maxPrice) {
        this.maxPrice = maxPrice;
    }

    public int getMarketValue() {
        return marketValue;
    }

    public void setMarketValue(int marketValue) {
        this.marketValue = marketValue;
    }

    public String getEndingDate() {
        return endingDate;
    }

    public void setEndingDate(String endingDate) {
        this.endingDate = endingDate;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getBidCount() {
        return bidCount;
    }

    public void setBidCount(int bidCount) {
        this.bidCount = bidCount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getBidAmount() {
        return bidAmount;
    }

    public void setBidAmount(int bidAmount) {
        this.bidAmount = bidAmount;
    }
}
