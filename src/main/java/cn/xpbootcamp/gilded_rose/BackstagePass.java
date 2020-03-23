package cn.xpbootcamp.gilded_rose;

import org.joda.time.Days;
import org.joda.time.LocalDate;

public class BackstagePass extends Goods {

    private String showDate;

    public BackstagePass(int sellIn, int quality, String listedDate, String showDate) {
        super(sellIn, quality, listedDate);
        this.showDate = showDate;
    }

    public String getShowDate() {
        return showDate;
    }

    @Override
    public void updateQualityAndSellIn() {
        LocalDate producedDate = new LocalDate(this.getListedDate());
        LocalDate today = new LocalDate();
        LocalDate showDate = new LocalDate(this.getShowDate());
        int betweenShowDays = Days.daysBetween(today, showDate).getDays();
        int betweenProducedDays = Days.daysBetween(producedDate, today).getDays();
        if (betweenShowDays < 0) {
            this.setQuality(MIN_QUALITY);
        } else if (betweenShowDays > 10) {
            this.setQuality(this.getQuality() + betweenProducedDays);
        } else if (betweenShowDays > 5) {
            this.setQuality(this.getQuality() + 2 * betweenProducedDays);
        } else {
            this.setQuality(this.getQuality() + 3 * betweenProducedDays);
        }
        this.setSellIn(this.getSellIn() + Math.abs(betweenProducedDays));
        this.setListedDate(today.toString());
    }
}
