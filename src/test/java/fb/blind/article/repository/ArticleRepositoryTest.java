package fb.blind.article.repository;

import fb.blind.common.NowDate;
import fb.blind.domain.article.Article;
import fb.blind.domain.article.repository.ArticleRepository;
import fb.blind.domain.article.repository.MemoryArticleRepository;
import fb.blind.domain.comment.*;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;


import java.util.ArrayList;
import java.util.List;

public class ArticleRepositoryTest {

    private ArticleRepository ar = new MemoryArticleRepository();
    private CommentRepository cr = new MemoryCommentRepository();

    private RecommentRepository rcr = new MemmoryRecommentRepository();

    @AfterEach
    public void afterEach(){
        ar.clear();
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
    @Test
    public void recommentTest(){
        Comment comment1 = new Comment(1,1,1,"테스트1 댓글입니다.","2023-01-18");
        Comment comment2 = new Comment(1,2,2,"테스트2 댓글입니다.","2023-01-18");
        cr.save(comment1);
        cr.save(comment2);
        Recomment recomment1 = new Recomment(1,1,"테스트 대댓글1입니다.","2023-01-22");
        Recomment recomment2 = new Recomment(2,2,"테스트 대댓글2입니다.","2023-01-22");
        rcr.save(recomment1);
        rcr.save(recomment2);
        // 댓글
        List<Comment> comments = cr.findByArticleId(1);
        // 대댓글

        List<Recomment> recomments = new ArrayList<Recomment>();
        for (Comment comment : comments) {
            recomments.add(rcr.findByCommId(comment.getId()).get(0));
        }

        for (Recomment r :
                recomments) {
            System.out.println(r.toString());
        }
    }
}
