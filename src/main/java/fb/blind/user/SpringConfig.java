package fb.blind.user;

import fb.blind.user.repository.MemoryUserRepository;
import fb.blind.user.repository.UserRepository;
import fb.blind.user.service.MemoryUserService;
import fb.blind.user.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public UserService userService(){
        return new MemoryUserService( new MemoryUserRepository());
    }

    @Bean
    public UserRepository userRepository(){
        return new MemoryUserRepository();
    }
}
