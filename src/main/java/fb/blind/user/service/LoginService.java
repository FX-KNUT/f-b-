package fb.blind.user.service;

import fb.blind.domain.user.User;
import fb.blind.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.lang.reflect.Member;

@Slf4j
@Service
@RequiredArgsConstructor
public class LoginService {

    private final UserRepository ur;

    public User login(String loginEmail, String loginPasswd){
        return ur.findByEmail(loginEmail)
                .filter(user -> user.getPasswd().equals(loginPasswd)).orElse(null);
    }

}
