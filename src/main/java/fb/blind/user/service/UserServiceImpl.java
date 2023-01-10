package fb.blind.user.service;

import fb.blind.domain.question.Question;
import fb.blind.domain.user.User;
import fb.blind.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository ur;

    @Override
    public User login(String email, String passwd) {
        User user = ur.findByEmail(email).get();
        return user.getPasswd().equals(passwd)? user : null;
    }

    @Override
    public User join(User user) {
        User findUser = ur.findByEmail(user.getEmail()).get();
        if(findUser != null){
            return ur.save(user);
        }
        return null;
    }

    @Override
    public void logout(User user) {

    }

    @Override
    public void withdrawal(User user) {
        User target = ur.findByEmail(user.getEmail()).get();
        ur.delete(target.getId());
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
