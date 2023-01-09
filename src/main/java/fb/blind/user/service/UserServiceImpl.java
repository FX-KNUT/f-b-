package fb.blind.user.service;

import fb.blind.domain.question.Question;
import fb.blind.domain.user.User;
import fb.blind.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository ur;

    @Override
    public User login(String email, String passwd) {

        return null;
    }

    @Override
    public User join(User user) {
        return null;
    }

    @Override
    public void logout(User user) {

    }

    @Override
    public void withdrawal(long userId) {

    }

    @Override
    public String findEmail(Question question) {
        return null;
    }

    @Override
    public String findPasswd(Question question) {
        return null;
    }
}
