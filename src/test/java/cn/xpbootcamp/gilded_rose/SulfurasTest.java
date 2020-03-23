package cn.xpbootcamp.gilded_rose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SulfurasTest {

    public static final int NO_SELLIN = -1;
    public static final String NO_PRODUCED_DATE = "NO PRODUCED DATE";

    @Test
    public void shouldHaveSulfuras() {
        Sulfuras sulfuras = new Sulfuras(10,10,"2020-03-21");

        assertEquals(NO_SELLIN, sulfuras.getSellIn());
        assertEquals(NO_PRODUCED_DATE, sulfuras.getListedDate());
    }

    @Test
    public void shouldNotChangeSulfurasQuality() {
        Sulfuras sulfuras = new Sulfuras(10,10,"2020-03-21");
        sulfuras.updateQualityAndSellIn();

        assertEquals(10, sulfuras.getQuality());
    }
}
