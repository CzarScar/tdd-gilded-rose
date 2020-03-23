package cn.xpbootcamp.gilded_rose;

import org.joda.time.Days;
import org.joda.time.LocalDate;

public class AgedBrie extends Goods{

    public AgedBrie(int sellIn, int quality, String producedDate) {
        super(sellIn, quality, producedDate);
    }

    @Override
    public void updateQuality() {
        LocalDate today = new LocalDate();
        LocalDate producedDate = new LocalDate(this.getProduceddate());
        int days = Days.daysBetween(producedDate, today).getDays();
        this.setQuality(this.getQuality() + days * SINGLE);
    }
}
