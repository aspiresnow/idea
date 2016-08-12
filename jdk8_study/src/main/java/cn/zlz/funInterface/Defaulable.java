package cn.zlz.funInterface;

/**
 * ${DESCRIPTION}
 * Created by zhanglizhi on 2016/8/3.
 */
@FunctionalInterface
public interface Defaulable {
    public void abstractFun();
    //在接口中使用default声明方法，可以被实现类继承或者覆写。
    default String notRequired(){
        return "Default implementation";
    }
}
