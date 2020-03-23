package cn.xpbootcamp.gilded_rose;

public class Sulfuras extends Goods{

    public static final int NO_SELLIN = -1;
    public static final String NO_PRODUCED_DATE = "NO PRODUCED DATE";

    public Sulfuras(int sellIn, int quality, String listedDate) {
        super(sellIn, quality, listedDate);
    }


    @Override
    public int getSellIn() {
        return NO_SELLIN;
    }

    @Override
    public String getListedDate() {
        return NO_PRODUCED_DATE;
    }

    @Override
    public void updateQualityAndSellIn() {}
}
