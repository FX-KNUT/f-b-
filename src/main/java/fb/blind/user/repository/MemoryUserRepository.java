package fb.blind.user.repository;

import fb.blind.domain.user.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class MemoryUserRepository implements UserRepository{

    private static Map<Long, User> store=new HashMap<>();
    private static long sequence=0L;

    @Override
    public void save(User user){
        user.setId(++sequence);
        store.put(user.getId(),user);

    }

    @Override
    public Optional<User> findByEmail(String email) {
        return Optional.ofNullable(store.get(email));
    }


    @Override
    public Optional<User> findByNickName(String nickName){
        return store.values().stream()
                .filter(user -> user.getNickName().equals(nickName))
                .findAny();
    }

    @Override
    public Optional<List<User>> findByDept(String dept){
        return Optional.empty();
    }

    @Override
    public void delete(long userid) {

    }

    @Override
    public Optional<List<User>> findAll() {
        return Optional.empty();
    }

    @Override
    public void clear() {

    }
}
