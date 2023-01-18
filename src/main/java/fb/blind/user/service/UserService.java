package fb.blind.user.service;

import fb.blind.domain.article.Article;
import fb.blind.domain.profile.Profile;
import fb.blind.domain.question.Question;
import fb.blind.domain.user.User;
import fb.blind.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

public interface UserService {
    /**
     * @param email user email
     * @param passwd user passwd
     * @return 로그인 된 User 객체 반환
     */

    User login(String email, String passwd);

    /**
     * @param user 가입 시 입력 된 user 객체
     * @return 가입 완료 된 User 객체를 반환
     */
    User join(User user);

    /**
     * @param user 로그인 된 user 객체
     */
    void logout(User user);

    /**
     * @param userId user 고유 id
     * 회원 탈퇴 기능
     */
    void withdrawal(long userId);

    /**
     * @param question 질문 객체
     * @return email 반환
     */
    String findEmail(Question question);

    /**
     * @param question 질문 객체
     * @return passwd 반환
     * reversion 필요
     */
    String findPasswd(Question question);

}
