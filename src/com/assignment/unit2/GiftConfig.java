package com.assignment.unit2;

public class GiftConfig {
    private String  giftcode;
    private String  giftName;
    private boolean  free;
    private double  rate;
    private int  limitTotal;
    private int  limitPlayer;

    public GiftConfig() {
    }

    public GiftConfig(String giftcode, String giftName, boolean free, double rate, int limitTotal, int limitPlayer) {
        this.giftcode = giftcode;
        this.giftName = giftName;
        this.free = free;
        this.rate = rate;
        this.limitTotal = limitTotal;
        this.limitPlayer = limitPlayer;
    }

}
