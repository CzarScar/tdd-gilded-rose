package cn.xpbootcamp.gilded_rose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GoodsTest {

    @Test
    public void shouldHaveGoodsWithTenSellInAndTwentyQuality() throws Exception {
        Goods goods = new Goods(10, 20);
        assertEquals(10, goods.getSellIn());
        assertEquals(20, goods.getQuality());
    }

    @Test
    public void goodsQualityShouldNoMoreThanFifty() {
        Exception exception = assertThrows(RuntimeException.class, () -> {Goods goods = new Goods(10, 51);});
        String expectedMessage = "no more than fifty";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void goodsQualityShouldNoLessThanZero() {
        Exception exception = assertThrows(RuntimeException.class, () -> {Goods goods = new Goods(10, -1);});
        String expectedMessage = "no less than zero";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }
}
