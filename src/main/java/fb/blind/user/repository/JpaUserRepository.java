package fb.blind.user.repository;

import fb.blind.domain.user.User;

import java.util.List;
import java.util.Optional;

public class JpaUserRepository implements UserRepository{

    private final EntityManager em;

    public JpaUserRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Optional<User> save(User user) {
        User user =  em.persist(user.class, user);
        return Optional.ofNullable(user);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return Optional.empty();
    }

    @Override
    public Optional<User> findByNickName(String nickName) {
        em.createQuery("select u from User u where u.nickName = :nickName", User.class)
                .setParameter("nickName",nickName)
                .getResultLsit();
        return result.stream().findAny();
    }

    @Override
    public Optional<List<User>> findByDept(long dept) {
        return Optional.empty();
    }

    @Override
    public Optional<User> delete(long userid) {
        User user = em.find(User.class, userid);
        return Optional.ofNullable(user);
    }

    @Override
    public List<User> findAll() {
        return em.createQuery("select u from User u", User.class)
                .getResultList();
    }

    @Override
    public void clear() {

    }
}
