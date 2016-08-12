package cn.zlz.util;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.*;

/**
 * ${DESCRIPTION}
 * Created by zhanglizhi on 2016/8/4.
 */
public class TestStreamPerfrm {
    static List<Integer> list = null;

    static {
        // 100000
        list = new ArrayList<Integer>();
        Random random = new Random();
        for (int i = 0; i < 1000; i++) {
            int val = random.nextInt();
            list.add(val);
        }
    }

    public static void main(String[] args) {
        LocalDateTime now1 = LocalDateTime.now();
        Integer max1 = iteratorTest(list);
        LocalDateTime now2 = LocalDateTime.now();
        int max2 = forEachTest(list);
        LocalDateTime now3 = LocalDateTime.now();
        int max3 = forTest(list);
        LocalDateTime now4 = LocalDateTime.now();
        parallelStreamTest(list);
        LocalDateTime now5 = LocalDateTime.now();
        int max5 = lambdaTest(list);
        LocalDateTime now6 = LocalDateTime.now();

        streamTest(list);
        LocalDateTime now7 = LocalDateTime.now();
        System.out.println("itrator use time is :" + Duration.between(now1, now2).toMillis());
        System.out.println("forEach use time is :" + Duration.between(now2, now3).toMillis());
        System.out.println("for use time is :" + Duration.between(now3, now4).toMillis());
        System.out.println("parallelStream use time is :" + Duration.between(now4, now5).toMillis());
        System.out.println("lambda use time is :" + Duration.between(now5, now6).toMillis());
        System.out.println("stream use time is :" + Duration.between(now6, now7).toMillis());

        // Duration.between();
    }

    public static int iteratorTest(List<Integer> list) {
        int max = Integer.MIN_VALUE;
        for (Iterator it = list.iterator(); it.hasNext(); ) {
            max = Integer.max(max, (Integer) it.next());
        }
        return max;
    }

    public static int forEachTest(List<Integer> list) {
        int max = Integer.MIN_VALUE;
        for (Integer n : list) {
            max = Integer.max(max, n);
        }
        return max;
    }

    public static int forTest(List<Integer> list) {
        int max = Integer.MIN_VALUE;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            max = Integer.max(max, list.get(i));
        }
        return max;
    }

    public static Object parallelStreamTest(List<Integer> list) {
        Optional max = list.parallelStream().reduce(Integer::max);
        return max.get();
    }

    public static int lambdaTest(List<Integer> list) {
        return list.stream().reduce(Integer.MIN_VALUE, (a, b) -> Integer.max(a, b));
    }

    public static Object streamTest(List<Integer> list) {
        Optional max = list.stream().reduce(Integer::max);
        return max.get();
    }
}
