package cn.zlz.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * ${DESCRIPTION}
 * Created by zhanglizhi on 2016/8/8.
 */
public class PredicateStudy {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList(Arrays.asList(1, 2, 3, 4, 5));
        boolean b = list.stream().allMatch(item -> item < 100);
        System.out.println(b);

        //创建一个predicate对象
        Predicate<String> predicate = (s) -> s.length() > 3;
        //调用方法接口方法 test
        System.out.println(predicate.test("fff"));
        System.out.println(predicate.negate().test("fff"));
        Predicate<Object> predicate1 = Predicate.isEqual("fff");
        System.out.println(predicate1.test("fff"));
        System.out.println(predicate.and(predicate1).test("fff"));
        System.out.println(predicate.or(predicate1).test("fff"));


    }
}
