package fb.blind.user.repository;

import fb.blind.domain.user.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository{
    /**
     * @param user user 객체 저장
     * @return
     */


    Optional<User> save(User user);

    /**
     * @param email user email (id 대용)
     * @return user 객체 return
     */




    Optional<User> findByEmail(String email);

    /**
     * @param nickName 닉네임
     * @return user 객체 리턴
     */

    Optional<User> findByNickName(String nickName);

    /**
     * @param dept 소속
     * @return user List 반환
     */

    Optional<List<User>> findByDept(long dept);

    /**
     * @param userid user 고유 id
     * @return
     */
    Optional<User> delete(long userid);

    /**
     * @return user List 반환
     */
    List<User> findAll();

    /**
     * Repository clear 용 test 시 사용
     */
    void clear();

}
