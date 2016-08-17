package cn.zlz.util;

import java.util.Random;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

/**
 * ${DESCRIPTION}
 * Created by zhanglizhi on 2016/8/16.
 */
public class RandomStudy {
    public static void main(String[] args) {
        Random random = new Random();
        //创建一个无穷的int流,随机数(0-100)之间
        IntStream intStream = random.ints(0, 100);
        //无穷流使用limit截断
        intStream.limit(10).forEach(System.out::println);
        DoubleStream doubleStream = random.doubles();
        doubleStream.limit(10).forEach(System.out::println);
    }
}
