package fb.blind.user.service;

import fb.blind.domain.article.Article;
import fb.blind.domain.profile.Profile;
import fb.blind.domain.question.Question;
import fb.blind.domain.user.User;

import java.util.Map;

public interface UserService {

    User login(String email, String passwd);

    User join(User user);

    void logout(User user);

    void withdrawal(long userId);

    String findEmail(Question question);
    String findPasswd(Question question);

}
