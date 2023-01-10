package fb.blind.user.service;

import fb.blind.domain.question.Question;
import fb.blind.domain.user.User;
import fb.blind.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
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
    public boolean join(User user) {
        Optional<User> findUser = ur.findByEmail(user.getEmail());
        List<User> result = ur.findAll();
        if(findUser != null){
            for (User u : result) {
                if(u.getEmail().equals(user.getEmail())){
                    return false;
                }
            }
            ur.save(user);
            return true;
        }
        return false;
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

    public Optional<User> findUserByEmail(String email){
        return ur.findByEmail(email);
    }


}
