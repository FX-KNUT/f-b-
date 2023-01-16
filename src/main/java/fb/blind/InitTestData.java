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
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class InitTestData {

    private final ArticleRepository ar;
    private final UserRepository ur;
    private final KindRepository kr;

    private final ProfileRepository pr;

    @PostConstruct
    public void setTestData(){
        Article arA = new Article("testA", "test", NowDate.getNowDate(), null,"shin",1L);
        Article arB = new Article("testB", "test", NowDate.getNowDate(), null,"shin",1L);
        Article arC = new Article("testC", "test", NowDate.getNowDate(), null,"shin",1L);
        Article arD = new Article("testD", "test", NowDate.getNowDate(), null,"shin",2L);
        Article arE = new Article("testE", "test", NowDate.getNowDate(), null,"shin",2L);
        Article arF = new Article("testF", "test", NowDate.getNowDate(), null,"shin",2L);
        Article arG = new Article("testG", "test", NowDate.getNowDate(), null,"shin",3L);
        Article arH = new Article("testH", "test", NowDate.getNowDate(), null,"shin",3L);
        Article arI = new Article("testI", "test", NowDate.getNowDate(), null,"shin",3L);
        Article arJ = new Article("testJ", "test", NowDate.getNowDate(), null,"shin",4L);
        Article arK = new Article("testK", "test", NowDate.getNowDate(), null,"shin",4L);
        Article arL = new Article("testL", "test", NowDate.getNowDate(), null,"shin",4L);

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

        kr.save(free);
        kr.save(secret);
        kr.save(game);
        kr.save(cat);

        log.info("free : {}",free.getId());
        log.info("secret : {}",secret.getId());
        log.info("game : {}",game.getId());
        log.info("cat : {}",cat.getId());

    }

    @PostConstruct
    public void setUserTestData(){

        User userA = new User("KNUT", "김민기", "rlaalsrl@gmail.com", "1234");
        User userB = new User("KNUT", "김성은", "rlatjddms@gmail.com", "1234");
        User userC = new User("KNUT", "신영운", "tlsduddns@gmail.com", "1234");

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
