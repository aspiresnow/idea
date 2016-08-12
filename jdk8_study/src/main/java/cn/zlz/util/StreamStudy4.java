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
        List<String> list = new ArrayList<String>(Arrays.asList("a", "bb", "cccc"));
        //注意Stream可以添加泛型
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


    }
}
