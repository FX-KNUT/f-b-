package fb.blind.user.repository;

import fb.blind.domain.user.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;

@Slf4j
@Repository
public class MemoryUserRepository implements UserRepository{

    private final Map<Long,User> store = new HashMap<>();

    private long userId = 0L;

    /**
     * @author 김성은,신영운
     * @param user user 객체 저장
     */
    @Override
    public User save(User user) {
        user.setId(++userId);
        store.put(user.getId(), user);
        return store.get(userId);
    }

    /**
     * @author 김성은,신영운
     * @param email user email (id 대용)
     * @return
     */
    @Override
    public Optional<User> findByEmail(String email) {
        for (User user : store.values()) {
            if(user.getEmail() == email){
                return Optional.ofNullable(user);
            }
        }
        return Optional.empty();
    }

    /**
     * @author 김성은,신영운
     * @param nickName 닉네임
     * @return
     */

    @Override
    public Optional<User> findByNickName(String nickName) {
        for (User user : store.values()) {
            if(user.getNickName() == nickName){
                return Optional.ofNullable(user);
            }
        }
        return Optional.empty();
    }

    /**
     * @author 김성은,신영운
     * @param dept 소속
     * @return
     */
    @Override
    public List<User> findByDept(String dept) {
        ArrayList<User> result = new ArrayList<>();
        for (User user : store.values()) {
            if(user.getDept() == dept){
                result.add(user);
            }
        }
        return result;
    }

    /**
     * @author 김성은,신영운
     * @param userId user 고유 id
     */
    @Override
    public void delete(long userId) {
        store.remove(userId);
    }

    /**
     * @author 김성은,신영운
     * @return
     */
    @Override
    public List<User> findAll() {
        return new ArrayList<>(store.values());
    }

    /**
     * @author 김성은,신영운
     */
    @Override
    public void clear() {
        store.clear();
    }
}
