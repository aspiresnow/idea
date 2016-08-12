package cn.zlz.util;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

/**
 * ${DESCRIPTION}
 * Created by zhanglizhi on 2016/8/4.
 */
public class ParallelArraysStudy {
    public static void main(String[] args) {
        long[] arrayOfLong = new long[20000];
        Arrays.parallelSetAll(arrayOfLong,index -> ThreadLocalRandom.current().nextInt(1000000));
        Arrays.stream(arrayOfLong).limit(10).forEach(i -> System.out.println(i+" "));
        System.out.println();
        Arrays.parallelSort(arrayOfLong);
        Arrays.stream(arrayOfLong).limit(10).forEach(i -> System.out.println(i+" "));
        System.out.println();
    }
}
