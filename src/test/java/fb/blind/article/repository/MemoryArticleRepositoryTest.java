package fb.blind.article.repository;

import fb.blind.common.NowDate;
import fb.blind.domain.article.Article;
import fb.blind.domain.article.repository.ArticleRepository;
import fb.blind.domain.article.repository.MemoryArticleRepository;
import fb.blind.domain.article.service.ArticleService;
import fb.blind.domain.article.service.ArticleServiceImpl;
import fb.blind.domain.comment.*;
import fb.blind.domain.kind.Kind;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

class MemoryArticleRepositoryTest {

    private ArticleRepository ar = new MemoryArticleRepository();

    private CommentRepository cr = new MemoryCommentRepository();

    private RecommentRepository rcr = new MemmoryRecommentRepository();

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
        Article arA = new Article("testA", "test", NowDate.getNowDate(), null,"shin",996L);
        Article arB = new Article("testB", "test", NowDate.getNowDate(), null,"shin",996L);
        Article arC = new Article("testC", "test", NowDate.getNowDate(), null,"shin",996L);
        Article arD = new Article("testD", "test", NowDate.getNowDate(), null,"shin",997L);
        Article arE = new Article("testE", "test", NowDate.getNowDate(), null,"shin",997L);
        Article arF = new Article("testF", "test", NowDate.getNowDate(), null,"shin",997L);
        Article arG = new Article("testG", "test", NowDate.getNowDate(), null,"shin",998L);
        Article arH = new Article("testH", "test", NowDate.getNowDate(), null,"shin",998L);
        Article arI = new Article("testI", "test", NowDate.getNowDate(), null,"shin",998L);


        Article arJ = new Article("testJ", "test", NowDate.getNowDate(), null,"shin",999L);
        Article arK = new Article("testK", "test", NowDate.getNowDate(), null,"shin",999L);
        Article arL = new Article("testL", "test", NowDate.getNowDate(), null,"shin",999L);

        arA.setId(1);
        arB.setId(989L);
        arC.setId(990L);
        arD.setId(991L);
        arE.setId(992L);
        arF.setId(993L);
        arG.setId(994L);
        arH.setId(995L);
        arI.setId(996L);
        arJ.setId(997L);
        arK.setId(998L);
        arL.setId(999L);

        ar.save(arA);
        ar.save(arB);
        ar.save(arC);
        ar.save(arD);
        ar.save(arE);
        ar.save(arF);
        ar.save(arG);
        ar.save(arH);
        ar.save(arI);
        ar.save(arJ);
        ar.save(arK);
        ar.save(arL);

        Comment comment1 = new Comment(1,1,1,"테스트1 댓글입니다.","2023-01-18");
        Comment comment2 = new Comment(1,2,2,"테스트2 댓글입니다.","2023-01-18");
        cr.save(comment1);
        cr.save(comment2);
        Recomment recomment1 = new Recomment(1,1,"테스트 대댓글1입니다.","2023-01-22");
        Recomment recomment2 = new Recomment(2,2,"테스트 대댓글2입니다.","2023-01-22");
        rcr.save(recomment1);
        rcr.save(recomment2);
    }


}