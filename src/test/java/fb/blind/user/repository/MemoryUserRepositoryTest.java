package fb.blind.user.repository;

import fb.blind.domain.user.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.AutoConfigureWebClient;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.PostConstruct;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;


class MemoryUserRepositoryTest {

    private UserRepository ur = new MemoryUserRepository();
    User user1;
    User user2;
    User user3;
    @AfterEach
    public void afterEach(){
        ur.clear();
    }

    @BeforeEach
    public void beforeEach(){
         user1 = new User("KNUT", "kim", "spring1@naver.com", "1234");
         user2 = new User("KNUT", "min", "spring2@naver.com", "1234");
         user3 = new User("KNUT", "shin", "spring3@naver.com", "1234");
         ur.save(user1);
         ur.save(user2);
         ur.save(user3);
    }

    @Test
    void save() {
        User userA = new User("KNUT", "kim", "spring99@naver.com", "1234");
        User user = ur.save(userA);
        assertThat(user.getEmail()).isEqualTo(userA.getEmail());
    }

    @Test
    void findByEmail() {
        User user = ur.findByEmail("spring2@naver.com").get();
        assertThat(user.getNickName()).isEqualTo("min");
    }

    @Test
    void findByNickName() {
        User user = ur.findByNickName("kim").get();
        assertThat(user.getEmail()).isEqualTo("spring1@naver.com");
    }

    @Test
    void findByDept() {
        List<User> result = ur.findByDept("KNUT");
        assertThat(result.size()).isEqualTo(3);
        assertThat(result).contains(user1,user2,user3);
    }

    @Test
    void delete() {
        ur.delete(user1.getId());
        List<User> result = ur.findByDept("KNUT");
        assertThat(result.size()).isEqualTo(2);
        assertThat(result).doesNotContain(user1);
    }

    @Test
    void findAll() {
        List<User> result = ur.findAll();
        assertThat(result.size()).isEqualTo(3);
        assertThat(result).contains(user1,user2,user3);
    }

}