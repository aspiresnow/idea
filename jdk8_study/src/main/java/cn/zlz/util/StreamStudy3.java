package cn.zlz.util;

import cn.zlz.domain.Task;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * ${DESCRIPTION}
 * Created by zhanglizhi on 2016/8/4.
 */
public class StreamStudy3 {
    public static void main(String[] args) {
    long x = 1l;
        System.out.println(x/2);
        List<Task> list = Arrays.asList(new Task(Task.Status.OPEAN, 5), new Task(Task.Status.CLOSED, 8), new Task(Task.Status.OPEAN, 13));
        int sum = list.stream().filter((s) -> s.getStatus() == Task.Status.OPEAN)
                .mapToInt(Task::getPoints).sum();
        System.out.println("sum is :" + sum);

        Integer totalPoints = list.stream().parallel()
                .map(task -> task.getPoints())
                .reduce(0, Integer::sum);
        System.out.println("Total points (all tasks):" + totalPoints);

        Map<Task.Status, List<Task>> map = list.stream().collect(Collectors.groupingBy(Task::getStatus));
        System.out.println(map);

        // List<String> result = list.stream().mapToInt(Task::getPoints).asLongStream()
        //         .mapToDouble(points -> points / totalPoints)
        //         .boxed()
        //         .mapToLong(weigth -> (long) (weigth * 100))
        //         .mapToObj(percentage -> percentage + "%")
        //         .collect(Collectors.toList());
        // System.out.println(result);

        final Collection< String > result = list
                .stream()                                        // Stream< String >
                .mapToInt( Task::getPoints )                     // IntStream
                .asDoubleStream()                                  // DoubleStream
                .map( points -> points / totalPoints )   // DoubleStream
                .boxed()                                         // Stream< Double >
                .mapToLong( weigth -> ( long )( weigth * 100 ) ) // LongStream
                .mapToObj( percentage -> percentage + "%" )      // Stream< String>
                .collect( Collectors.toList() );                 // List< String >
            System.out.println( result );
        String fileName = "d:\\1.txt";
        File file = new File(fileName);
        Path path =  file.toPath();
        try {
            Stream<String> lines = Files.lines(path, StandardCharsets.UTF_8);
            lines.onClose(() -> System.out.println("Done!")).forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
