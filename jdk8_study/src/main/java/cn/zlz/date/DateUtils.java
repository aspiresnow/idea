package cn.zlz.date;

import java.time.*;

/**
 * ${DESCRIPTION}
 * Created by zhanglizhi on 2016/8/16.
 */
public class DateUtils {
    public static void main(String[] args) {
        ZoneId london = ZoneId.of("Europe/London");
        LocalDate july4 = LocalDate.of(2014,Month.JULY,4);
        LocalTime early = LocalTime.parse("08:05");
        ZonedDateTime flightDeparture = ZonedDateTime.of(july4,early,london);
        System.out.println(flightDeparture);
        LocalTime from = LocalTime.from(flightDeparture);
        System.out.println(from);
        ZonedDateTime touchDown = ZonedDateTime.of(july4,
                LocalTime.of(11,35),
                ZoneId.of("Europe/Stockholm"));
        Duration flightLength = Duration.between(flightDeparture,touchDown);
        System.out.println(flightLength);
        ZonedDateTime now = ZonedDateTime.now();
        Duration timeHere = Duration.between(touchDown,now);
        System.out.println(timeHere);
    }
}
