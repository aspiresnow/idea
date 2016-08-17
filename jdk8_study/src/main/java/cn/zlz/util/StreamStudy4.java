package cn.zlz.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * ${DESCRIPTION}
 * Created by zhanglizhi on 2016/8/8.
 */
public class StreamStudy4 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>(Arrays.asList("bb", "a", "cccc"));
        // 注意Stream可以添加泛型
        Stream<String> stream = list.stream();
        // System.out.println(stream.anyMatch(s -> s.equals("bb")));
        // System.out.println(stream.allMatch(s -> s.equals("bb")));
        // System.out.println(stream.noneMatch(s -> s.equals("bb")));
        // Stream stream = stream.skip(3);//过滤掉前3个元素
        // Stream.Builder<String> builder = Stream.builder();//创建一个Stream.builder类似stringBuffer的东东
        // builder.add("d");
        // builder.add("e");
        // Stream<String> buildStream = builder.build();//将Stream.builder构造为Stream
        // buildStream.forEach(s -> System.out.println(s));

        // Stream concatStream = Stream.concat(buildStream, stream);//连接两个Stream
        // concatStream.forEach(s -> System.out.println(s));

        // list.add("d");long count = stream.count();//计算Stream管道关联的数据源中元素的个数
        // System.out.println(count);

        // list.add("a"); Stream distinctStream = stream.distinct();//根据obj.equals(obj)过滤到相同的元素
        // distinctStream.forEach(s -> System.out.println(s));

        // Stream<Object> emptyStream = Stream.empty();//创建一个空的Stream

        // Stream filterStream = stream.filter(s -> s.equals("b"));//过滤Stream
        // filterStream.forEach(s -> System.out.println(s));

        // Optional anyOptional = stream.findAny();//取的是数据源中第一个元素？？？
        // System.out.println(anyOptional.get());

        // Optional firstOptional = stream.findFirst();//取的是数据源中第一个元素
        // System.out.println(firstOptional.get());

        // Stream mapStream = stream.map(s -> s+"bbb");
        // mapStream.forEach(s -> System.out.println(s));
        //创建Stream
        // Stream<List<Integer>> inputStream = Stream.of(
        //         Arrays.asList(1),
        //         Arrays.asList(2, 3),
        //         Arrays.asList(4, 5, 6)
        // );
        //flatMapstream 将子元素的stream流合并到主流中
        //关系上区分是 map是针对一对一关系，flatMap针对一对多关系
        //flatMap：和map类似，不同的是其每个元素转换得到的是Stream对象，
        // 会把子Stream中的元素压缩到父集合中；
        // Stream<Integer> flatMapstream = inputStream.
        //         flatMap((childList) -> childList.stream());
        // flatMapstream.forEach(s -> System.out.println(s));

        //创建一个无穷大的Stream，配合limit使用
        // Stream<String> generateStream = Stream.generate(() -> new String("a")).limit(10);
        // generateStream.forEach(s -> System.out.println(s));
        //获取最大值
        // Optional maxOptionnal = stream.max((String s1,String s2) -> s1.length()-s2.length());
        // System.out.println(maxOptionnal.get());

        //返回原有的Stream，并给Stream中的每个元素绑定一个消费函数，当每个元素被消费之前都会执行消费函数
        // Stream<String> peekStream = stream.peek((s) -> {
        //     System.out.println(s+"1");
        // });
        // peekStream.forEach(s -> System.out.println(s));

        //排序
        // Stream<String> sortedStream = stream.sorted((s1,s2) -> s2.compareTo(s1));
        // sortedStream.forEach(s -> System.out.println(s));

        //转换为数组
        // Object[] objects = stream.toArray();
        // for (int i = 0; i < objects.length; i++) {
        //     Object object = objects[i];
        //     System.out.println(object);
        // }


        /**
         * collect 接收3个参数
         * 1、Supplier<R> supplier --创建一个新的容器（使用并发流的时候注意会被多次调用）
         * 2、BiConsumer<R,? super T> accumulator --Stream中的元素添加到一个容器中
         * 3、BiConsumer<R,R> combiner) --合并上面两个容器
         */
        // List<Integer> nums = Arrays.asList(1, 1, null, 2, 3, 4, null, 5, 6, 7, 8, 9, 10);
        // // List<Integer> numsWithoutNull = nums.stream().filter(num -> num != null).
        // //         collect(() -> new ArrayList<Integer>(),
        // //                 (list, item) -> list.add(item),
        // //                 (list1, list2) -> list1.addAll(list2));
        // List<Integer> numsWithoutNull = nums.stream().filter(num -> num != null).
        //         collect(Collectors.toList());
        // numsWithoutNull.forEach(s -> System.out.println(s));



    }
}
