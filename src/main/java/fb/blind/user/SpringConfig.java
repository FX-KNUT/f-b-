package fb.blind.user;

import fb.blind.user.repository.MemoryUserRepository;
import fb.blind.user.repository.UserRepository;
import fb.blind.user.service.MemoryUserService;
import fb.blind.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
public class SpringConfig {

    @Autowired
    public UserService userService(){
        return new MemoryUserService( new MemoryUserRepository());
    }

    @Autowired
    public UserRepository userRepository(){
        return new MemoryUserRepository();
    }
}
