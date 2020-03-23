package cn.xpbootcamp.gilded_rose;

public class Goods {
    public String getSellIn() {
        return SellIn;
    }

    public int getQuality() {
        return Quality;
    }

    public String SellIn;

    public void setQuality(int quality) {
        Quality = quality;
    }

    public int Quality;

    public Goods(String SellIn, int Quality) {
        this.SellIn = SellIn;
        if (Quality > 50 || Quality < 0) {
            throw new RuntimeException("Quality should no more than fifty or no less than zero");
        }
        this.Quality = Quality;
    }
}
