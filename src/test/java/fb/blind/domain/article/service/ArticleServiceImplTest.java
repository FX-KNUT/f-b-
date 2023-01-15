package fb.blind.domain.article.service;

import fb.blind.common.NowDate;
import fb.blind.domain.article.Article;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ArticleServiceImplTest {

    @Autowired
    private ArticleService ar;

    @Test
    void addArticle() {

        Article article = new Article("testA", "aaaa", NowDate.getNowDate(), "shin", 999L);

        Article saved = ar.addArticle(article);

        assertThat(article.getTitle()).isEqualTo(saved.getTitle());

    }

    @Test
    void readArticle() {
        Article article = new Article("testA", "aaaa", NowDate.getNowDate(), "shin", 999L);
        ar.addArticle(article);
        Article result = ar.readArticle(1L).get();

        assertThat(result.getTitle()).isEqualTo("testA");

    }

    @Test
    void updateArticle() {
        Article article = new Article("testA", "aaaa", NowDate.getNowDate(), "shin", 999L);
        ar.addArticle(article);
        Article change = new Article("testB", "bbbb", NowDate.getNowDate(), "shin", 999L);
        change.setId(article.getId());
        ar.updateArticle(change);
        Article result = ar.readArticle(article.getId()).get();
        assertThat(result).isEqualTo(change);
    }

    @Test
    void deleteArticle() {
        Article article = new Article("testA", "aaaa", NowDate.getNowDate(), "shin", 999L);
        ar.addArticle(article);
        System.out.println("ar.readArticle(13L) = " + ar.readArticle(article.getId()));
        ar.deleteArticle(article.getId());
        assertThat(ar.readArticle(article.getId())).isNotPresent();
    }

    @Test
    void articleList() {
        List<Article> articles = ar.articleList(996L);
        articles.stream().forEach(m -> System.out.println("m = " + m));
        assertThat(articles.get(0).getId()).isEqualTo(1);
    }

    @Test
    void getURL() {
        String url = ar.getURL(1L);
        System.out.println("url :  " + url);
        assertThat(url).isEqualTo("http://localhost8080/articles/" + 1);
    }

    @Test
    void findByKindId() {
        List<Article> byKindId = ar.findByKindId(996L);
        System.out.println("byKindId = " + byKindId);
    }
}