package Repository;

import fb.blind.domain.user.User;
import fb.blind.user.repository.MemoryUserRepository;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class MemoryUserRepositoryTest {
    MemoryUserRepository repository= new MemoryUserRepository();

    @Test
    public void save()
    {
        User user = new User();
        user.setNickName("spring");

        repository.save(user);

        User result = repository.findByUserId(user.getId()).get();
        assertThat(user).isEqualTo(result);

    }
    @Test
    public void findByNickName(){
        User user1 = new User();
        user1.setNickName("spring1");
        repository.save(user1);

        User user2 = new User();
        user2.setNickName("spring2");
        repository.save(user2);

        User result= repository.findByNickName("spring1").get();

        asssertThat(result).isEqualTo(user1);
    }

    @Test
    public void findAll(){
        User user1 = new User();
        user1.setNickName("spring1");
        repository.save(user1);

        User user2 = new User();
        user2.setNickName("spring2");
        repository.save(user2);
        List<User> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);
    }
}

