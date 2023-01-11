package fb.blind.user.repository;

import fb.blind.domain.user.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    /**
     * @author 김성은,신영운
     * @param user user 객체 저장
     */
    User save(User user);

    /**
     * @author 김성은,신영운
     * @param nickName 닉네임
     * @return user 객체 리턴
     */
    Optional<User> findByNickName(String nickName);

    /**
     * @author 김성은,신영운
     * @param dept 소속
     * @return user List 반환
     */
    List<User> findByDept(String dept);

    /**
     * @author 김성은,신영운
     * @param userId user 고유 id
     */
    void delete(long userId);

    /**
     * @author 김성은,신영운
     * @return user List 반환
     */
    List<User> findAll();

    /**
     * @author 김성은,신영운
     * Repository clear 용 test 시 사용
     */
    void clear();

}
