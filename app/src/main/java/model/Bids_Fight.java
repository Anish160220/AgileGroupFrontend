package model;

public class Bids_Fight {
    private int bid_fightId,bidId, bidderId,bidAmount;

    public Bids_Fight(int bidId, int bidderId, int bidAmount) {
        this.bidId = bidId;
        this.bidderId = bidderId;
        this.bidAmount = bidAmount;
    }

    public int getBid_fightId() {

        return bid_fightId;
    }

    public void setBid_fightId(int bid_fightId) {
        this.bid_fightId = bid_fightId;
    }

    public int getBidId() {
        return bidId;
    }

    public void setBidId(int bidId) {
        this.bidId = bidId;
    }

    public int getBidderId() {
        return bidderId;
    }

    public void setBidderId(int bidderId) {
        this.bidderId = bidderId;
    }

    public int getBidAmount() {
        return bidAmount;
    }

    public void setBidAmount(int bidAmount) {
        this.bidAmount = bidAmount;
    }
}
