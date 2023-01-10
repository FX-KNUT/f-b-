package fb.blind.user.service;

import fb.blind.domain.question.Question;
import fb.blind.domain.user.User;
import org.springframework.validation.BindingResult;

import java.util.Optional;

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
    boolean join(User user);

    /**
     * @param user 로그인 된 user 객체
     */
    void logout(User user);

    /**
     * @param user user
     * 회원 탈퇴 기능
     */
    void withdrawal(User user);

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

    Optional<User> findUserByEmail(String email);

    Optional<User> findUserByNick(String nick);

    void checkedFormPolicy(User user, BindingResult bindingResult);
}
