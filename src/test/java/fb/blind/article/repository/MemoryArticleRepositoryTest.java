package fb.blind.article.repository;

import fb.blind.domain.article.Article;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemoryArticleRepositoryTest {

    private ArticleRepository ar = new MemoryArticleRepository();

    @AfterEach
    public void afterEach(){
        ar.clear();
    }
    @Test
    @DisplayName("save")
    @Disabled
    void save() { }

    @Test
    @DisplayName("이메일로 찾기")
    @Disabled
    void findByEmail() {}

    @Test
    @DisplayName("제목으로 찾기")
    void findByTitle() {
        Article article = new Article("testA", "test", "2023-01-06", null);
        ar.save(article);
        Article testA = ar.findByTitle("testA");
        assertThat(testA.getTitle()).isEqualTo(article.getTitle());
    }

    @Test
    @DisplayName("Article id 로 찾기")
    void findByArticleId() {
        Article article = new Article("testA", "test", "2023-01-06", null);
        article.setId(1L);
        ar.save(article);
        Article testA = ar.findByArticleId(1L).get();
        assertThat(testA.getId()).isEqualTo(1L);
    }

    @Test
    void delete() {
        Article article = new Article("testA", "test", "2023-01-06", null);
        article.setId(1L);
        ar.save(article);
        System.out.println("article = " + article.getTitle());
        ar.delete(1L);
        Optional<Article> test = ar.findByArticleId(1L);
        // isNotPresent ==> null 이면 true : Not null false
        // isPresent ==> null 이면 false : Not null true
        //System.out.println("article = " + test.get().getTitle());
        assertThat(test).isNotPresent();
    }

    @Test
    void findAll() {
        setTestData();
        List<Article> result = ar.findAll();
        long testid = 0L;
        for (Article article : result) {
            System.out.println("article.getId() = " + article.getId());
            assertThat(article.getId()).isEqualTo(++testid);
        }
    }

    private void setTestData(){
        Article arA = new Article("testA", "test", "2023-01-06", null);
        Article arB = new Article("testB", "test", "2023-01-06", null);
        Article arC = new Article("testC", "test", "2023-01-06", null);
        ar.save(arA);
        ar.save(arB);
        ar.save(arC);
    }
}