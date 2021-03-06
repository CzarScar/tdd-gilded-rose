package cn.xpbootcamp.gilded_rose;

import org.joda.time.LocalDate;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GoodsTest {

    @Test
    public void shouldHaveGoodsWithTenSellInAndTwentyQuality() {
        String listedDate = "2020-03-21";
        Goods goods = new Goods(10, 20, listedDate);
        assertEquals(10, goods.getSellIn());
        assertEquals(20, goods.getQuality());
        assert (listedDate.equals(goods.getListedDate()));
    }

    @Test
    public void goodsQualityShouldNoMoreThanFifty() {
        Exception exception = assertThrows(RuntimeException.class, () -> {
            new Goods(10, 51, "2020-03-21");
        });
        String expectedMessage = "no more than fifty";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void goodsQualityShouldNoLessThanZero() {
        Exception exception = assertThrows(RuntimeException.class, () -> {
            new Goods(10, -1, "2020-03-21");
        });
        String expectedMessage = "no less than zero";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void goodsQualityShouldDerease() {
        String producedDate = new LocalDate().minusDays(1).toString();
        String today = new LocalDate().toString();
        Goods goods = new Goods(1, 20, producedDate);
        goods.updateQualityAndSellIn();

        assertEquals(19, goods.getQuality());
        assertEquals(0, goods.getSellIn());
        assertEquals(today, goods.getListedDate());
    }

    @Test
    public void goodsQualityDecreasedWhenExpired() {
        String listedDate = new LocalDate().minusDays(2).toString();
        Goods goods = new Goods(1, 20, listedDate);
        goods.updateQualityAndSellIn();

        assertEquals(17, goods.getQuality());
        assertEquals(0, goods.getSellIn());
    }

    @Test
    public void goodsQualityDecreasedToZeroWhenExpired() {
        String listedDate = new LocalDate().minusDays(25).toString();
        Goods goods = new Goods(20, 20, listedDate);
        goods.updateQualityAndSellIn();

        assertEquals(0, goods.getQuality());
        assertEquals(0, goods.getSellIn());
    }

    @Test
    public void shouldUpdateQualityAndSellIn() {
        String listedDate = new LocalDate().minusDays(2).toString();
        Goods goods = new Goods(10, 20, listedDate);
        goods.updateQualityAndSellIn();

        assertEquals(18, goods.getQuality());
        assertEquals(8, goods.getSellIn());
    }
}
