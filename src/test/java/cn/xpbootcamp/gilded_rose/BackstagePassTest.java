package cn.xpbootcamp.gilded_rose;

import org.joda.time.LocalDate;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BackstagePassTest {

    @Test
    public void shouldHaveBackstagetPass() {
        String listedDate = "2020-03-21";
        String showDate = "2020-04-01";
        BackstagePass backstagePass = new BackstagePass(10, 10, listedDate, showDate);

        assertEquals(10, backstagePass.getQuality());
        assertEquals(10, backstagePass.getSellIn());
        assertEquals(listedDate, backstagePass.getListedDate());
    }

    @Test
    public void shouldUpdateSellInAndQualityWhenShowTimePassed() {
        String showDate = new LocalDate().minusDays(1).toString();
        String listedDate = new LocalDate().minusDays(3).toString();
        String today = new LocalDate().toString();
        BackstagePass backstagePass = new BackstagePass(10, 10, listedDate, showDate);
        backstagePass.updateQualityAndSellIn();

        assertEquals(0, backstagePass.getQuality());
        assertEquals(13, backstagePass.getSellIn());
        assertEquals(today, backstagePass.getListedDate());
    }

    @Test
    public void shouldUpdateSellInAndQualityWhenMoreThanTenDaysToShowTime(){
        String showDate = new LocalDate().plusDays(15).toString();
        String listedDate = new LocalDate().minusDays(1).toString();
        String today = new LocalDate().toString();
        BackstagePass backstagePass = new BackstagePass(10, 10, listedDate, showDate);
        backstagePass.updateQualityAndSellIn();

        assertEquals(11, backstagePass.getQuality());
        assertEquals(11, backstagePass.getSellIn());
        assertEquals(today, backstagePass.getListedDate());
    }

    @Test
    public void shouldUpdateSellInAndQualityWhenTenDaysToShowTime(){
        String showDate = new LocalDate().plusDays(10).toString();
        String listedDate = new LocalDate().minusDays(1).toString();
        String today = new LocalDate().toString();
        BackstagePass backstagePass = new BackstagePass(10, 10, listedDate, showDate);
        backstagePass.updateQualityAndSellIn();

        assertEquals(12, backstagePass.getQuality());
        assertEquals(11, backstagePass.getSellIn());
        assertEquals(today, backstagePass.getListedDate());
    }

    @Test
    public void shouldUpdateSellInAndQualityWhenFiveDaysToShowTime(){
        String showDate = new LocalDate().plusDays(5).toString();
        String listedDate = new LocalDate().minusDays(1).toString();
        String today = new LocalDate().toString();
        BackstagePass backstagePass = new BackstagePass(10, 10, listedDate, showDate);
        backstagePass.updateQualityAndSellIn();

        assertEquals(13, backstagePass.getQuality());
        assertEquals(11, backstagePass.getSellIn());
        assertEquals(today, backstagePass.getListedDate());
    }
}
