package fb.blind.domain.user.service;

import fb.blind.domain.question.Question;
import fb.blind.domain.user.User;
import fb.blind.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository ur;

    @Override
    public User login(String email, String passwd) {
        User user = findByEmail(email).get();
        return user.getPasswd().equals(passwd)? user : null;
    }

    @Override
    public boolean join(User user) {
        Optional<User> findUser = findByEmail(user.getEmail());
        return joinProcess(user, findUser);
    }

    @Override
    public void logout(User user) {

    }

    @Override
    public void withdrawal(User user) {
        User target = findByEmail(user.getEmail()).get();
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
        log.info(email);
        return findByEmail(email);
    }

    public Optional<User> findUserByNick(String nick){
        return ur.findByNickName(nick);
    }

    @Override
    public void checkedFormPolicy(User user, BindingResult bindingResult) {
        checkDuplicateEmail(user,bindingResult);
        checkDuplicateNick(user,bindingResult);
    }

    private void checkDuplicateNick(User user,BindingResult bindingResult) {
        Optional<User> userByNick = findUserByNick(user.getNickName());

        if(!userByNick.isEmpty()){
            bindingResult.reject("duplicationNick");
        }

    }

    private void checkDuplicateEmail(User user,BindingResult bindingResult) {
        Optional<User> userByEmail = findUserByEmail(user.getEmail());

        if(!userByEmail.isEmpty()){
            bindingResult.reject("duplicationEmail");
        }
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return ur.findAll().stream().filter(m -> m.getEmail().equals(email)).findAny();
    }

    private boolean joinProcess(User user, Optional<User> findUser) {
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

}
