package cn.zlz.date;


import java.time.*;
import java.util.Date;

/**
 * ${DESCRIPTION}
 * Created by zhanglizhi on 2016/8/4.
 */
public class ClockStudy {
    public static void main(String[] args) {
        Clock clock = Clock.systemUTC();
        System.out.println(clock.instant());
        System.out.println(clock.millis());
        Date date = new Date();
        System.out.println(date);

        LocalDate now = LocalDate.now();
        LocalDate nowFromClock  = LocalDate.now(clock);
        System.out.println("now is:"+now);
        System.out.println("nowFromClock is:"+nowFromClock);

        LocalTime nowTime = LocalTime.now();
        LocalTime nowTimeFromClock = LocalTime.now(clock);
        System.out.println("nowTime is :"+nowTime);
        System.out.println("nowTimeFromClock is :"+nowTimeFromClock);

        LocalDateTime nowDateTime = LocalDateTime.now();
        LocalDateTime nowDateTimeFromClock = LocalDateTime.now(clock);
        System.out.println("nowDateTime is :"+nowDateTime);
        System.out.println("nowDateTimeFromClock is :"+nowDateTimeFromClock);

        ZonedDateTime nowZonedDateTime = ZonedDateTime.now();
        ZonedDateTime nowZonedDateTimeFromClock = ZonedDateTime.now(clock);
        ZonedDateTime owZonedDateTimeFromZone = ZonedDateTime.now(ZoneId.of("Asia/Shanghai"));
        System.out.println("nowZonedDateTime is :"+nowZonedDateTime);
        System.out.println("nowZonedDateTimeFromClock is :"+nowZonedDateTimeFromClock);
        System.out.println("owZonedDateTimeFromZone is :"+owZonedDateTimeFromZone);

        LocalDateTime from = LocalDateTime.of(2014, Month.APRIL, 16, 12, 10, 2);
        LocalDateTime to = LocalDateTime.of(2015, Month.APRIL, 17, 23, 59, 59);
        Duration duration = Duration.between(from, to);
        System.out.println("Duration in days :"+duration.toDays());
        System.out.println("Duration in hours :"+duration.toHours());


    }
}
