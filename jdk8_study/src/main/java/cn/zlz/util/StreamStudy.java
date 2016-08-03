package cn.zlz.util;

import cn.zlz.domain.Article;

import java.util.*;
import java.util.stream.Collectors;

/**
 * ${DESCRIPTION}
 * Created by zhanglizhi on 2016/8/1.
 */
public class StreamStudy {
    public static void main(String[] args) {
        
        List<Article> articles = new ArrayList<Article>();
        for (int i = 0; i < 10; i++) {
            Article article = new Article();
            article.setTitle("title"+i);
            article.setAuthor("author"+i%3);
            if(i==2){
                article.setTags(Arrays.asList("e", "f"));
                articles.add(article);
            }else {
                article.setTags(Arrays.asList("a", "b", "c", "a", "c"));
                articles.add(article);
            }
        }
        // Map<String, List<Article>> map = groupByAuthor_tradition(articles);
        // Map<String, List<Article>> map = groupByAuthor_new(articles);
        // System.out.println(map.size());
        Set<String> set = getDistinctTags_new(articles);
        for(String str:set){
            System.out.println(str);
        }
    }

    public static Map<String, List<Article>> groupByAuthor_tradition(List<Article> articles) {

        Map<String, List<Article>> result = new HashMap<>();

        for (Article article : articles) {
            if (result.containsKey(article.getAuthor())) {
                result.get(article.getAuthor()).add(article);
            } else {
                ArrayList<Article> list = new ArrayList<>();
                list.add(article);
                result.put(article.getAuthor(), list);
            }
        }

        return result;
    }

    public static Map<String, List<Article>> groupByAuthor_new(List<Article> articles) {
        return articles.stream()
                .collect(Collectors.groupingBy(Article::getAuthor));
    }

    public static Set<String> getDistinctTags_tradition(List<Article> articles) {
        Set<String> result = new HashSet<>();
        for (Article article : articles) {
            result.addAll(article.getTags());
        }
        return result;
    }

    public static Set<String> getDistinctTags_new(List<Article> articles) {
        return articles.stream()
                .flatMap(article -> article.getTags().stream())
                .collect(Collectors.toSet());
    }
}
