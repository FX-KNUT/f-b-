package fb.blind.user.service;

import fb.blind.domain.question.Question;
import fb.blind.domain.user.User;
import fb.blind.user.repository.UserRepository;

public class MemoryUserService implements UserService{
    private final UserRepository userRepository;

    public MemoryUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


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
