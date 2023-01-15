package fb.blind.domain.user.repository;

import fb.blind.domain.user.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.*;

@Slf4j
@Repository
public class MemoryUserRepository implements UserRepository{

    private static Map<Long,User> store = new HashMap<>();

    private long userId = 0L;
    /**
     * @author 김성은,신영운
     * @Parma userid => 고유 ID
     * @param user user 객체 저장
     */
    @Override
    public User save(User user) {
        user.setId(++userId);
        store.put(user.getId(), user);
        return store.get(userId);
    }

    /**
     * @param nickName 닉네임
     * @return
     * @author 김성은, 신영운
     */

    @Override
    public Optional<User> findByNickName(String nickName) {
        return Optional.ofNullable(store.values().stream()
                .filter(m -> m.getNickName().equals(nickName)).findFirst().orElse(null));
    }

    /**
     * @author 김성은,신영운
     * @param dept 소속
     * @return
     */
    @Override
    public List<User> findByDept(String dept) {
        ArrayList<User> result = new ArrayList<>();
        store.values().stream().forEach(user -> {
            if(user.getDept().equals(dept)){
                result.add(user);
            }
        });
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
