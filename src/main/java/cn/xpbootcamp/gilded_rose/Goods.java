package cn.xpbootcamp.gilded_rose;

import org.joda.time.Days;
import org.joda.time.LocalDate;

public class Goods {

    public static final int DOUBLE = 2;
    public static final int SINGLE = 1;
    public static final int MAX_QUALITY = 50;
    public static final int MIN_QUALITY = 0;
    public static final int MIN_SELLIN = 0;

    private int sellIn;
    private int quality;

    private String listedDate;

    public Goods(int sellIn, int quality, String listedDate) {
        this.sellIn = sellIn;
        if (quality > MAX_QUALITY || quality < MIN_QUALITY) {
            throw new RuntimeException("Quality should no more than fifty or no less than zero");
        }
        this.quality = quality;
        this.listedDate = listedDate;
    }

    public void setSellIn(int sellIn) {
        this.sellIn = sellIn;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }

    public void setListedDate(String listedDate) {
        this.listedDate = listedDate;
    }

    public int getSellIn() {
        return sellIn;
    }

    public int getQuality() {
        return quality;
    }

    public String getListedDate() {
        return listedDate;
    }

    public void updateQualityAndSellIn() {
        LocalDate today = new LocalDate();
        LocalDate producedDate = new LocalDate(this.getListedDate());
        int quality = 0;
        int days = Days.daysBetween(producedDate, today).getDays();
        if (days < this.getSellIn()) {
            quality = this.getQuality() - SINGLE * days;
        } else {
            quality = this.getQuality() - SINGLE * this.getSellIn() - DOUBLE * (days - this.getSellIn());
        }
        this.setQuality(quality > MIN_QUALITY ? quality : MIN_QUALITY);

        this.setSellIn(this.getSellIn() < days ? MIN_SELLIN : this.getSellIn() - days);
        this.setListedDate(today.toString());
    }
}
