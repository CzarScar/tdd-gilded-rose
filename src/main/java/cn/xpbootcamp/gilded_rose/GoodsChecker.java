package cn.xpbootcamp.gilded_rose;

import org.joda.time.Days;
import org.joda.time.LocalDate;

public class GoodsChecker {

    public static final int DOUBLE = 2;
    public static final int SINGLE = 1;

    public void update(Goods goods) {
        LocalDate today = new LocalDate();
        LocalDate producedDate = new LocalDate(goods.getProduceddate());
        int quality = 0;
        int days = Days.daysBetween(producedDate, today).getDays();
        if (days < goods.getSellIn()) {
            quality = goods.getQuality() - SINGLE * days;
        } else {
            quality = goods.getQuality() - SINGLE * goods.getSellIn() - DOUBLE * (days - goods.getSellIn());
        }
        goods.setQuality(quality > 0 ? quality : 0);
    }
}