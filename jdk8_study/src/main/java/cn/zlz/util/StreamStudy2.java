package cn.zlz.util;

import cn.zlz.domain.Employee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.partitioningBy;

/**
 * ${DESCRIPTION}
 * Created by zhanglizhi on 2016/8/1.
 */
public class StreamStudy2 {
    public static void main(String[] args) {

    }

    public static Map groupBy_tradition(List<Employee> employees) {
        Map<String, List<Employee>> result = new HashMap<>();
        for (Employee e : employees) {
            String city = e.getCity();
            List<Employee> empsInCity = result.get(city);
            if (empsInCity == null) {
                empsInCity = new ArrayList<>();
                result.put(city, empsInCity);
            }
            empsInCity.add(e);
        }
        return result;
    }

    public static Map groupBy_new(List<Employee> employees) {
        Map<String, List<Employee>> map =
                employees.stream().collect(Collectors.groupingBy(Employee::getCity));
        return map;
    }

    //计算每个城市中雇员的数量
    public static Map count_new(List<Employee> employees) {
        Map<String, Long> map =
                employees.stream().collect(Collectors.groupingBy(Employee::getCity, counting()));
        return map;
    }

    //计算每个城市的平均年龄
    public static Map average_new(List<Employee> employees) {
        Map<String, Double> map =
                employees.stream().collect(Collectors.groupingBy(Employee::getCity,
                        Collectors.averagingInt(Employee::getNumSales)));
        return map;
    }

    ////////分区//////////////////////////////////
    public static Map partition_new(List<Employee> employees) {
        //map 至少包含两个不同的分组——一个true，一个false。例如，如果想找出最优秀的员工，你可以将所有雇员分为两组，一组销售量大于 N，另一组小于 N
        Map<Boolean, List<Employee>> map =
                employees.stream().collect(partitioningBy(e -> e.getNumSales() > 150));
        return map;
    }
    //统计每个分区中的每个城市的雇员人数
    public static Map parAndGroup_new(List<Employee> employees){
        Map<Boolean, Map<String, Long>> map =
                employees.stream().collect(partitioningBy(e -> e.getNumSales() > 150,
                        Collectors.groupingBy(Employee::getCity, Collectors.counting())));
        return map;
    }
    ////////分区//////////////////////////////////
}
