package fb.blind.article.repository;

import fb.blind.domain.article.Article;
import fb.blind.domain.article.repository.ArticleRepository;
import fb.blind.domain.article.repository.MemoryArticleRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

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
    @DisplayName("Article id 로 찾기")
    void findByArticleId() {
        Article article = new Article("testA", "test", "2023-01-06", null,1L);
        article.setId(1L);
        ar.save(article);
        Article testA = ar.findByArticleId(1L).get();
        assertThat(testA.getId()).isEqualTo(1L);
    }

    @Test
    void delete() {
        Article article = new Article("testA", "test", "2023-01-06", null,1L);
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
        Article arA = new Article("testA", "test", "2023-01-06", null,1L);
        Article arB = new Article("testA", "test", "2023-01-06", null,1L);
        Article arC = new Article("testA", "test", "2023-01-06", null,1L);
        ar.save(arA);
        ar.save(arB);
        ar.save(arC);
    }
}