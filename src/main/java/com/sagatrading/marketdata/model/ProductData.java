package com.sagatrading.marketdata.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
@Table
public class ProductData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @JsonProperty("BID_PRICE")
    private double BID_PRICE;

    @JsonProperty("SELL_LIMIT")
    private double SELL_LIMIT;

    @JsonProperty("ASK_PRICE")
    private double ASK_PRICE;

    @JsonProperty("BUY_LIMIT")
    private double BUY_LIMIT;

    @JsonProperty("MAX_PRICE_SHIFT")
    private double MAX_PRICE_SHIFT;

    @JsonProperty("TICKER")
    private String TICKER;

    @JsonProperty("LAST_TRADED_PRICE")
    private Double LAST_TRADED_PRICE;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBID_PRICE() {
        return BID_PRICE;
    }

    public void setBID_PRICE(double BID_PRICE) {
        this.BID_PRICE = BID_PRICE;
    }

    public double getSELL_LIMIT() {
        return SELL_LIMIT;
    }

    public void setSELL_LIMIT(double SELL_LIMIT) {
        this.SELL_LIMIT = SELL_LIMIT;
    }

    public double getASK_PRICE() {
        return ASK_PRICE;
    }

    public void setASK_PRICE(double ASK_PRICE) {
        this.ASK_PRICE = ASK_PRICE;
    }

    public double getBUY_LIMIT() {
        return BUY_LIMIT;
    }

    public void setBUY_LIMIT(double BUY_LIMIT) {
        this.BUY_LIMIT = BUY_LIMIT;
    }

    public double getMAX_PRICE_SHIFT() {
        return MAX_PRICE_SHIFT;
    }

    public void setMAX_PRICE_SHIFT(double MAX_PRICE_SHIFT) {
        this.MAX_PRICE_SHIFT = MAX_PRICE_SHIFT;
    }

    public String getTICKER() {
        return TICKER;
    }

    public void setTICKER(String TICKER) {
        this.TICKER = TICKER;
    }

    public Double getLAST_TRADED_PRICE() {
        return LAST_TRADED_PRICE;
    }

    public void setLAST_TRADED_PRICE(Double LAST_TRADED_PRICE) {
        this.LAST_TRADED_PRICE = LAST_TRADED_PRICE;
    }

    @Override
    public String toString() {
        return "ProductData{" +
                "id=" + id +
                ", BID_PRICE=" + BID_PRICE +
                ", SELL_LIMIT=" + SELL_LIMIT +
                ", ASK_PRICE=" + ASK_PRICE +
                ", BUY_LIMIT=" + BUY_LIMIT +
                ", MAX_PRICE_SHIFT=" + MAX_PRICE_SHIFT +
                ", TICKER='" + TICKER + '\'' +
                ", LAST_TRADED_PRICE=" + LAST_TRADED_PRICE +
                '}';
    }
}
