package cn.xpbootcamp.gilded_rose;

import org.joda.time.LocalDate;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GoodsTest {

    @Test
    public void shouldHaveGoodsWithTenSellInAndTwentyQuality() throws Exception {
        Goods goods = new Goods("2020-03-21", 20);
        assertEquals("2020-03-21", goods.getSellIn());
        assertEquals(20, goods.getQuality());
    }

    @Test
    public void goodsQualityShouldNoMoreThanFifty() {
        Exception exception = assertThrows(RuntimeException.class, () -> {
            new Goods("2020-03-21", 51);
        });
        String expectedMessage = "no more than fifty";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void goodsQualityShouldNoLessThanZero() {
        Exception exception = assertThrows(RuntimeException.class, () -> {
            new Goods("2020-03-21", -1);
        });
        String expectedMessage = "no less than zero";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void goodsQualityDecreasedWhenExpired() {
        LocalDate today = new LocalDate();
        Goods goods = new Goods(today.minusDays(1).toString(), 20);
        GoodsChecker checker = new GoodsChecker();
        checker.update(goods);

        assertEquals(18, goods.getQuality());
    }

    @Test
    public void goodsQualityDecreasedToZeroWhenExpired() {
        LocalDate today = new LocalDate();
        Goods goods = new Goods(today.minusDays(11).toString(), 20);
        GoodsChecker checker = new GoodsChecker();
        checker.update(goods);

        assertEquals(0, goods.getQuality());
    }
}
