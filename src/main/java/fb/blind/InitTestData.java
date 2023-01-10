package fb.blind;

import fb.blind.article.repository.ArticleRepository;
import fb.blind.domain.article.Article;
import fb.blind.domain.kind.Kind;
import fb.blind.kind.repository.KindRepository;
import fb.blind.kind.service.KindService;
import fb.blind.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@RequiredArgsConstructor
public class InitTestData {

    private final ArticleRepository ar;
    private final UserRepository ur;
    private final KindRepository kr;

    @PostConstruct
    public void setTestData(){
        Article arA = new Article("testA", "test", "2023-01-06", null,"shin",996L);
        Article arB = new Article("testB", "test", "2023-01-06", null,"shin",996L);
        Article arC = new Article("testC", "test", "2023-01-06", null,"shin",996L);
        Article arD = new Article("testD", "test", "2023-01-06", null,"shin",997L);
        Article arE = new Article("testE", "test", "2023-01-06", null,"shin",997L);
        Article arF = new Article("testF", "test", "2023-01-06", null,"shin",997L);
        Article arG = new Article("testG", "test", "2023-01-06", null,"shin",998L);
        Article arH = new Article("testH", "test", "2023-01-06", null,"shin",998L);
        Article arI = new Article("testI", "test", "2023-01-06", null,"shin",998L);


        Article arJ = new Article("testJ", "test", "2023-01-06", null,"shin",999L);
        Article arK = new Article("testK", "test", "2023-01-06", null,"shin",999L);
        Article arL = new Article("testL", "test", "2023-01-06", null,"shin",999L);

        arA.setId(988L);
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

    }

    @PostConstruct
    public void setKindTestData(){
        Kind free = new Kind("자유게시판");
        Kind secret = new Kind("비밀게시판");
        Kind game = new Kind("게임게시판");
        Kind cat = new Kind("고양이게시판");

        free.setId(996L);
        secret.setId(997L);
        game.setId(998L);
        cat.setId(999L);

        kr.save(free);
        kr.save(secret);
        kr.save(game);
        kr.save(cat);

    }



}
