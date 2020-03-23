package cn.xpbootcamp.gilded_rose;

public class Goods {
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
}
