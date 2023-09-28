package com.sagatrading.marketdata.model;

import com.fasterxml.jackson.annotation.JsonProperty;


public class ProductDataDTO {
    @JsonProperty("BID_PRICE")
    private int bidPrice;

    @JsonProperty("SELL_LIMIT")
    private int sellLimit;

    @JsonProperty("ASK_PRICE")
    private double askPrice;

    @JsonProperty("BUY_LIMIT")
    private int buyLimit;

    @JsonProperty("MAX_PRICE_SHIFT")
    private double maxPriceShift;

    @JsonProperty("TICKER")
    private String ticker;

    @JsonProperty("LAST_TRADED_PRICE")
    private double lastTradedPrice;

    public int getBidPrice() {
        return bidPrice;
    }

    public void setBidPrice(int bidPrice) {
        this.bidPrice = bidPrice;
    }

    public int getSellLimit() {
        return sellLimit;
    }

    public void setSellLimit(int sellLimit) {
        this.sellLimit = sellLimit;
    }

    public double getAskPrice() {
        return askPrice;
    }

    public void setAskPrice(double askPrice) {
        this.askPrice = askPrice;
    }

    public int getBuyLimit() {
        return buyLimit;
    }

    public void setBuyLimit(int buyLimit) {
        this.buyLimit = buyLimit;
    }

    public double getMaxPriceShift() {
        return maxPriceShift;
    }

    public void setMaxPriceShift(double maxPriceShift) {
        this.maxPriceShift = maxPriceShift;
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public double getLastTradedPrice() {
        return lastTradedPrice;
    }

    public void setLastTradedPrice(double lastTradedPrice) {
        this.lastTradedPrice = lastTradedPrice;
    }

    @Override
    public String toString() {
        return "ProductDataDTO{" +
                "bidPrice=" + bidPrice +
                ", sellLimit=" + sellLimit +
                ", askPrice=" + askPrice +
                ", buyLimit=" + buyLimit +
                ", maxPriceShift=" + maxPriceShift +
                ", ticker='" + ticker + '\'' +
                ", lastTradedPrice=" + lastTradedPrice +
                '}';
    }
}
