package cn.xpbootcamp.gilded_rose;

import org.joda.time.Days;
import org.joda.time.LocalDate;

public class GoodsChecker {

    public static final int DOUBLE = 2;

    public void update(Goods goods) {
        LocalDate today = new LocalDate();
        LocalDate sellInDate = new LocalDate(goods.getSellIn());
        int days = Days.daysBetween(sellInDate, today).getDays();
        int quality = goods.getQuality() - DOUBLE * days;
        goods.setQuality(quality < 0 ? 0 : quality);
    }
}