package fb.blind.user.service;

import fb.blind.domain.question.Question;
import fb.blind.domain.user.User;
import fb.blind.user.repository.UserRepository;

@Transactional
public class MemoryUserService implements UserService{
    private final UserRepository userRepository;

    /*
    public UserService save(User user){
        if(user.getId()==null){
            user.setId(++userCount);
        }
        user.add(user);
        return (UserService) user;
    }*/
    public MemoryUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public User login(String email, String passwd) {
        return null;
    }

    @Override
    public Long join(User user) {

        validateDuplicateUser(user);
        userRepository.save(user);
        return user.getId();
    }
    private void validateDuplicateUser(User user){
        userRepository.findByNickName(user.getNickName())
                .ifPresent(u ->{
                    throw new IllegalStateException(("이미 존재하는 회원입니다.");
                });

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
