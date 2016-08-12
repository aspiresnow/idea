package cn.zlz.util;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * ${DESCRIPTION}
 * Created by zhanglizhi on 2016/8/4.
 */
public class Base64Study {
    public static void main(String[] args) {
        String text = "Base64 finally in Jva 8!";
        String encoded = Base64.getEncoder().encodeToString(text.getBytes(StandardCharsets.UTF_8));
        System.out.println(encoded);

        String decoded = new String(Base64.getDecoder().decode(encoded),StandardCharsets.UTF_8);
        System.out.println(decoded);
    }
}
