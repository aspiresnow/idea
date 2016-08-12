package cn.zlz.domain;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

/**
 * ${DESCRIPTION}
 * Created by zhanglizhi on 2016/8/3.
 */
public class Car {
    private String name;

    public static Car create(Supplier<Car> supplier){
        return supplier.get();
    }

    public static void collide(final Car car){
        System.out.println("Collided " + car.toString());
    }

    public void follow(final Car another){
        System.out.println("Following the " + another.toString());
    }

    public void repair(){
        System.out.println("Repaired " + this.toString());
    }

    public static void main(String[] args) {
        Car car = Car.create(Car::new);
        List<Car> cars = Arrays.asList(car);
        cars.forEach(Car::collide);
        // cars.forEach(Car::follow);
        cars.forEach(Car::repair);
        Car police = Car.create(Car::new);
        cars.forEach(police::follow);

    }
}
