package cn.xpbootcamp.gilded_rose;

import org.joda.time.LocalDate;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GoodsTest {

    @Test
    public void shouldHaveGoodsWithTenSellInAndTwentyQuality() {
        String producedDate = "2020-03-21";
        Goods goods = new Goods(10, 20, producedDate);
        assertEquals(10, goods.getSellIn());
        assertEquals(20, goods.getQuality());
        assert(producedDate.equals(goods.getProduceddate()));
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
    public void goodsQualityShouldDerease(){
        String producedDate = new LocalDate().minusDays(1).toString();
        Goods goods = new Goods(1, 20, producedDate);
        GoodsChecker checker = new GoodsChecker();
        checker.update(goods);

        assertEquals(19, goods.getQuality());
    }

    @Test
    public void goodsQualityDecreasedWhenExpired() {
        String producedDate = new LocalDate().minusDays(2).toString();
        Goods goods = new Goods(1, 20, producedDate);
        GoodsChecker checker = new GoodsChecker();
        checker.update(goods);

        assertEquals(17, goods.getQuality());
    }

    @Test
    public void goodsQualityDecreasedToZeroWhenExpired() {
        String producedDate = new LocalDate().minusDays(25).toString();
        Goods goods = new Goods(20, 20, producedDate);
        GoodsChecker checker = new GoodsChecker();
        checker.update(goods);

        assertEquals(0, goods.getQuality());
    }
}
