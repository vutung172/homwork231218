package com.assignment.unit2;

public class GiftConfig implements IGift{
    private String  giftcode;
    private String  giftName;
    private boolean  free = false;
    private double  rate;
    private int  limitTotal;
    private int  limitPlayer;

    public GiftConfig() {
    }

    public GiftConfig(String giftcode, String giftName, boolean free, double rate, int limitTotal) {
        this.giftcode = giftcode;
        this.giftName = giftName;
        this.free = free;
        this.rate = rate;
        this.limitTotal = limitTotal;
    }

    public String getGiftcode() {
        return giftcode;
    }

    public void setGiftcode(String giftcode) {
        this.giftcode = giftcode;
    }

    public String getGiftName() {
        return giftName;
    }

    public void setGiftName(String giftName) {
        this.giftName = giftName;
    }

    public boolean isFree() {
        return free;
    }

    public void setFree(boolean free) {
        this.free = free;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public int getLimitTotal() {
        return limitTotal;
    }

    public void setLimitTotal(int limitTotal) {
        this.limitTotal = limitTotal;
    }

    public int getLimitPlayer() {
        return limitPlayer;
    }

    public void setLimitPlayer(int limitPlayer) {
        this.limitPlayer = limitPlayer;
    }

    @Override
    public void output() {
        System.out.printf("%s | %s | %s | %s | %s | %s |\n",getGiftcode(),getGiftName(),getRate(),isFree(),getLimitTotal(),getLimitPlayer());
    }
}
