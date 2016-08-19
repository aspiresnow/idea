package cn.zlz.date;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;

/**
 * ${DESCRIPTION}
 * Created by zhanglizhi on 2016/8/19.
 */
public class LocalStudy {
    public static void main(String[] args) {
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
        System.out.println(LocalDateTime.MAX);
        System.out.println(LocalDateTime.MIN);

        LocalDate localDate = LocalDate.of(2014, 12, 31);
        System.out.println(localDate);

        LocalTime localTime = LocalTime.of(12, 25,12);
        System.out.println(localTime);

        System.out.println("");

        Year year = Year.now();
        System.out.println("year :" + year);
//   从Year获取LocalDate
        LocalDate localDate1 = year.atDay(366);
        System.out.println("localDate1 :" + localDate1);
        LocalTime localtime = LocalTime.now();
        LocalDateTime localDateTime1 = localtime.atDate(localDate1);
        System.out.println("localDateTime1 :" + localDateTime1);

        DayOfWeek dayOfWeek = DayOfWeek.of(1);
        System.out.println(dayOfWeek);

        long between = ChronoUnit.DAYS.between(localDate, localDate1);
        System.out.println("between :" + between);

        // 线程安全的格式化类，不用每次都new个SimpleDateFormat
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        System.out.println("date formatter :" + dateTimeFormatter.format(localDate));
        //  解析字符串形式的日期时间
        TemporalAccessor temporalAccessor = dateTimeFormatter.parse("2013-01-15");
        System.out.println("temporalAccessor :" + LocalDate.from(temporalAccessor));

        Instant instant = Instant.now(); //  时间戳
        System.out.println("instant :" + instant);

        //计算某月的第一天的日期
        LocalDate with = localDate.with(TemporalAdjusters.firstDayOfMonth());
        System.out.println("with :" + with);

        // 计算某月的第一个星期一的日期
        TemporalAdjuster temporalAdjuster = TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY);
        LocalDate with1 = localDate.with(temporalAdjuster);
        System.out.println("with1 :" + with1);

        // 计算localDate的下一个星期一的日期
        LocalDate with2 = localDate.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
        System.out.println("with2 :" + with2);

        // java.util.Date到新库类的转换
        // 转换可通过下面的方法进行。
        Date date = new Date();
        System.out.println(date);
        Instant instant1 = date.toInstant();
        System.out.println(instant1);
        Date from = Date.from(instant1);
        System.out.println(from);
        // Calendar.toInstant()

        Instant timestamp = Instant.now();
        System.out.println("Current Timestamp = "+timestamp);

        //Instant from timestamp
        Instant specificTime = Instant.ofEpochMilli(timestamp.toEpochMilli());
        System.out.println("Specific Time = "+specificTime);

        //Duration example
        Duration thirtyDay = Duration.ofDays(30);
        System.out.println(thirtyDay);

        LocalDate today = LocalDate.now();

        //Get the Year, check if it's leap year
        System.out.println("Year "+today.getYear()+" is Leap Year? "+today.isLeapYear());

        //Compare two LocalDate for before and after
        System.out.println("Today is before 01/01/2015? "+today.isBefore(LocalDate.of(2015,1,1)));

        //Create LocalDateTime from LocalDate
        System.out.println("Current Time="+today.atTime(LocalTime.now()));

        //plus and minus operations
        System.out.println("20 days after today will be "+today.plusDays(20));
        System.out.println("3 weeks after today will be "+today.plusWeeks(3));
        System.out.println("20 months after today will be "+today.plusMonths(20));

        System.out.println("10 days before today will be "+today.minusDays(10));
        System.out.println("3 weeks before today will be "+today.minusWeeks(3));
        System.out.println("20 months before today will be "+today.minusMonths(20));

        //Temporal adjusters for adjusting the dates
        System.out.println("First date of this month= "+today.with(TemporalAdjusters.firstDayOfMonth()));
        LocalDate lastDayOfYear = today.with(TemporalAdjusters.lastDayOfYear());
        System.out.println("Last date of this year= "+lastDayOfYear);
        LocalDate ofDate = LocalDate.of(2016, 1, 1);
        Period period = ofDate.until(lastDayOfYear);
        System.out.println("Period Format= "+period);
        System.out.println("Months remaining in the year= "+period.getMonths());
    }
}
