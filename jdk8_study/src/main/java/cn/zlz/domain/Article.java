package cn.zlz.domain;

import lombok.Data;

import java.util.List;

/**
 * ${DESCRIPTION}
 * Created by zhanglizhi on 2016/8/1.
 */
@Data
public class Article {
    private String title;
    private String author;
    private List<String> tags;
}
