package cn.xpbootcamp.gilded_rose;

public class Goods {
    public int getSellIn() {
        return SellIn;
    }

    public int getQuality() {
        return Quality;
    }

    public int SellIn;
    public int Quality;

    public Goods(int SellIn, int Quality) {
        this.SellIn = SellIn;
        if(Quality>50 || Quality < 0){
            throw new RuntimeException("Quality should no more than fifty or no less than zero");
        }
        this.Quality = Quality;
    }
}
