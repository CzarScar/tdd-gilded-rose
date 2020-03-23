package cn.xpbootcamp.gilded_rose;

import org.joda.time.Days;
import org.joda.time.LocalDate;

public class Goods {

    public static final int DOUBLE = 2;
    public static final int SINGLE = 1;

    private int sellIn;
    private int quality;
    private String produceddate;

    public Goods(int sellIn, int quality, String producedDate) {
        this.sellIn = sellIn;
        if (quality > 50 || quality < 0) {
            throw new RuntimeException("Quality should no more than fifty or no less than zero");
        }
        this.quality = quality;
        this.produceddate = producedDate;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }

    public int getSellIn() {
        return sellIn;
    }

    public int getQuality() {
        return quality;
    }

    public String getProduceddate() {
        return produceddate;
    }

    public void updateQuality(){
        LocalDate today = new LocalDate();
        LocalDate producedDate = new LocalDate(this.getProduceddate());
        int quality = 0;
        int days = Days.daysBetween(producedDate, today).getDays();
        if (days < this.getSellIn()) {
            quality = this.getQuality() - SINGLE * days;
        } else {
            quality = this.getQuality() - SINGLE * this.getSellIn() - DOUBLE * (days - this.getSellIn());
        }
        this.setQuality(quality > 0 ? quality : 0);
    }
}
