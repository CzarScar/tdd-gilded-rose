package cn.xpbootcamp.gilded_rose;

import org.joda.time.LocalDate;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AgedBrieTest {

    @Test
    public void shouldHaveAgedBrie() {
        AgedBrie agedBrie = new AgedBrie(10, 10, "2020-03-21");

        assertEquals(10, agedBrie.getSellIn());
    }

    @Test
    public void shouldIncreaseQuality() {
        String producedDate = new LocalDate().minusDays(10).toString();
        AgedBrie agedBrie = new AgedBrie(10, 10, producedDate);
        agedBrie.updateQualityAndSellIn();

        assertEquals(20, agedBrie.getQuality());
    }

    @Test
    public void qualityShouldNoMoreThanFifty() {
        String producedDate = new LocalDate().minusDays(60).toString();
        AgedBrie agedBrie = new AgedBrie(10, 10, producedDate);
        agedBrie.updateQualityAndSellIn();

        assertEquals(50, agedBrie.getQuality());
    }
}
