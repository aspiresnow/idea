package cn.zlz.funInterface;

import java.util.function.Supplier;

/**
 * ${DESCRIPTION}
 * Created by zhanglizhi on 2016/8/3.
 */
public interface DefaulableFactory {
    static Defaulable create(Supplier<Defaulable> supplier){
        return supplier.get();
    }
}
