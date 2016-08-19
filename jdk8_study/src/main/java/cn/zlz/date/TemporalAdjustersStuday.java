package cn.zlz.date;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;

/**
 * ${DESCRIPTION}
 * Created by zhanglizhi on 2016/8/19.
 */
public class TemporalAdjustersStuday {
    public static void main(String[] args) {
        LocalDateTime localDateTime = LocalDateTime.of(2016,7,7,12,20,42);
        //获取从调用者当前月1号开始 第六个星期日
        LocalDateTime dateTime1 = localDateTime.with(TemporalAdjusters.dayOfWeekInMonth(3, DayOfWeek.of(5)));
        System.out.println("dayOfWeekInMonth : "+dateTime1);

        //获取调用者当前月第一天
        LocalDateTime dateTime2 = localDateTime.with(TemporalAdjusters.firstDayOfMonth());
        System.out.println("firstDayOfMonth : "+dateTime2);

        //获取调用者下月第一天
        LocalDateTime dateTime3 = localDateTime.with(TemporalAdjusters.firstDayOfNextMonth());
        System.out.println("firstDayOfNextMonth : "+dateTime3);
        //获取调用者当年第一天
        LocalDateTime dateTime4 = localDateTime.with(TemporalAdjusters.firstDayOfYear());
        System.out.println("firstDayOfYear : "+dateTime4);
        //获取调用者下年第一天
        LocalDateTime dateTime5 = localDateTime.with(TemporalAdjusters.firstDayOfNextYear());
        System.out.println("firstDayOfNextYear "+dateTime5);
        //获取调用者当前月第一个星期四所在日期
        LocalDateTime dateTime6 = localDateTime.with(TemporalAdjusters.firstInMonth(DayOfWeek.THURSDAY));
        System.out.println("firstInMonth "+dateTime6);
        //获取调用者当前月最后一天
        LocalDateTime dateTime7 = localDateTime.with(TemporalAdjusters.lastDayOfMonth());
        System.out.println("lastDayOfMonth "+dateTime7);
        //获取调用者当年最后一天
        LocalDateTime dateTime8 = localDateTime.with(TemporalAdjusters.lastDayOfYear());
        System.out.println("lastDayOfYear "+dateTime8);
        //获取调用者当前月最后一个星期四所在日期
        LocalDateTime dateTime9 = localDateTime.with(TemporalAdjusters.lastInMonth(DayOfWeek.THURSDAY));
        System.out.println("lastInMonth "+dateTime9);
        //获取调用者下一个星期四   next > 同理 previous
        LocalDateTime dateTime10 = localDateTime.with(TemporalAdjusters.next(DayOfWeek.THURSDAY));
        System.out.println("next "+dateTime10);
        //同next相似，只是当调用者满足条件的时候，直接返回调用者，nextOrSame >=  同理 previousOrSame
        LocalDateTime dateTime11 = localDateTime.with(TemporalAdjusters.nextOrSame(DayOfWeek.THURSDAY));
        System.out.println("nextOrSame "+dateTime11);
        //ofDateAdjuster 提供自定义接口
        LocalDateTime dateTime12 = localDateTime.with(TemporalAdjusters.ofDateAdjuster(date -> date.plusDays(2)));
        System.out.println("nextOrSame "+dateTime12);
    }
}
