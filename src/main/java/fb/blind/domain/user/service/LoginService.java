package fb.blind.domain.user.service;

import fb.blind.domain.user.User;
import fb.blind.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class LoginService {

    private final UserRepository ur;
    private final UserService us;

    public User login(String loginEmail, String loginPasswd){
        return us.findUserByEmail(loginEmail)
                .filter(user -> user.getPasswd().equals(loginPasswd)).orElse(null);
    }

}
