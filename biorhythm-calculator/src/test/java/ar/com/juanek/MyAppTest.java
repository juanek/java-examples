package ar.com.juanek;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;


public class MyAppTest {
    private static final Logger LOG = LoggerFactory.getLogger(MyAppTest.class);

    @Test
    public void myAppTest() {
        LOG.debug("hello test ");

        int range = 20;

        LocalDate medium = LocalDate.of(2021,06,04);
        LocalDate start = medium.minusDays(range / 2);
        LocalDate end = medium.plusDays(range / 2);
        List<LocalDate> dates = Stream
                .iterate(start, date -> date.plusDays(1))
                .limit(ChronoUnit.DAYS.between(start, end))
                .collect(Collectors.toList());
        assertThat(dates.size()).isEqualTo(range);
        LOG.info("{}",dates);
    }
}
