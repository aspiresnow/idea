package cn.zlz.funInterface.impl;

import cn.zlz.funInterface.Defaulable;
import cn.zlz.funInterface.DefaulableFactory;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * ${DESCRIPTION}
 * Created by zhanglizhi on 2016/8/3.
 */
public class DefaulableImpl implements Defaulable {

    public static void main(String[] args) {
        Defaulable defaulable = DefaulableFactory.create(DefaulableImpl::new);
        defaulable.abstractFun();
        System.out.println(defaulable.notRequired());
    }

    @Override
    public void abstractFun() {
        try {
            Method method = this.getClass().getMethod("main",String[].class);
            for( final Parameter parameter: method.getParameters() ) {
                System.out.println( "Parameter: " + parameter.getName() );
            }

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
