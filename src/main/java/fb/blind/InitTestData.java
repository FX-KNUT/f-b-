package fb.blind;

import fb.blind.common.NowDate;
import fb.blind.domain.article.repository.ArticleRepository;
import fb.blind.domain.Gender;
import fb.blind.domain.article.Article;
import fb.blind.domain.kind.Kind;
import fb.blind.domain.profile.Profile;
import fb.blind.domain.user.User;
import fb.blind.domain.kind.repository.KindRepository;
import fb.blind.domain.profile.repository.ProfileRepository;
import fb.blind.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class InitTestData {

    private final ArticleRepository ar;
    private final UserRepository ur;
    private final KindRepository kr;

    private final ProfileRepository pr;

    @PostConstruct
    public void setTestData(){
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
        Kind free = new Kind("???????????????");
        Kind secret = new Kind("???????????????");
        Kind game = new Kind("???????????????");
        Kind cat = new Kind("??????????????????");


        free.setId(996L);
        secret.setId(997L);
        game.setId(998L);
        cat.setId(999L);

        kr.save(free);
        kr.save(secret);
        kr.save(game);
        kr.save(cat);

    }
    @PostConstruct
    public void setUserTestData(){
        User userA = new User("KNUT", "?????????", "rlaalsrl@gmail.com", "1234");
        User userB = new User("KNUT", "?????????", "rlatjddms@gmail.com", "1234");
        User userC = new User("KNUT", "?????????", "tlsduddns@gmail.com", "1234");

        User saveA = ur.save(userA);
        User saveB = ur.save(userB);
        User saveC = ur.save(userC);

        Profile profileA = new Profile(Gender.M, null, saveA.getId());
        Profile profileB = new Profile(Gender.W, null, saveB.getId());
        Profile profileC = new Profile(Gender.M, null, saveC.getId());

        pr.save(profileA);
        pr.save(profileB);
        pr.save(profileC);

    }



}
