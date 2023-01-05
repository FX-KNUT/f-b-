package fb.blind.user.repository;

import fb.blind.domain.user.User;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;

public interface UserRepository {
    void save(User user);
    Optional<User> findByEmail(String email);
    Optional<User> findByNickName(String nickName);
    Optional<List<User>> findByDept(String dept);

    void delete(long userid);

    Optional<List<User>> findAll();

    /*clear는 알아서 짤것*/

}
