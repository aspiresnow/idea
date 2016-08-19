package cn.zlz.date;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalQueries;
import java.time.temporal.ValueRange;

/**
 * ${DESCRIPTION}
 * Created by zhanglizhi on 2016/8/19.
 */
public class DateStudy {

    public static void main(String[] args) {

        LocalDate localdate = LocalDate.now();
        System.out.println("today is : " + localdate);
        /**
         * TemporalAccessor：所有日期类型的基础接口，提供日期的查询(只读)功能
         * 不要直接使用接口，在子类中使用，例如在localDate中调用
         */
        int monthOfYear = localdate.get(ChronoField.MONTH_OF_YEAR);
        System.out.println(monthOfYear);
        ValueRange dayOfMonth = localdate.range(ChronoField.DAY_OF_MONTH);
        System.out.println(dayOfMonth);
        /**
         * 没太懂TemporalQueries提供的几个静态方法作用
         */
        LocalDate queryLocalDate = localdate.query(TemporalQueries.localDate());
        System.out.println("queryLocalDate is : "+queryLocalDate);
        /**
         * Temporal：接口，提供基本的日期加减和复制(with)功能
         */
        //判断当前日期是否支持该类型的 加减
        LocalDate localDate1 = LocalDate.of(2016, 8, 30);
        if (localdate.isSupported(ChronoUnit.MONTHS)){
            //计算两个日期之间的差额
            long duration = localdate.until(localDate1, ChronoUnit.MONTHS);
            System.out.println(duration);
        }
        //with方法时复制
        LocalDate date = localdate.with(localDate1);
        System.out.println(date);
        LocalDate date1 = localdate.with(ChronoField.MONTH_OF_YEAR, 10);
        System.out.println(date1);
        //减日期
        LocalDate minusDate1 = localdate.minus(1, ChronoUnit.DAYS);
        System.out.println(minusDate1);
        /**
         * TemporalAmount 表示存储一段时间，可以用来做日期加减
         *      实现类：
         *          period：存储年月日
         *          duration：存储秒和纳秒，但是提供了对时间格式的一些支持
         */
        Period period = Period.ofDays(2);
        LocalDate minusPeriodDate = localdate.minus(period);
        System.out.println(minusPeriodDate);

        /**
         * TemporalAdjuster 是一个方法接口(lambda)，接收一个Temporal接口，对该日期进行操作，然后返回，
         * 主要是操作日期的一个工具，使用TemporalAdjusters返回预定的一些功能
         */
    }
}
