package fb.blind.domain.user;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class User {
    /**
     * @Param id : user 고유 id
     * @Param dept : 소속
     * @Param nickName : 닉네임
     * @Param email : 로그인 id -> e-mail 형식
     * @Param passwd : pw
     * @Param createDate : user  생성 시간
     */
    private long id;
    private String dept;
    private String nickName;
    private String email;
    private String passwd;
    private LocalDateTime createDate = LocalDateTime.now();

    public User() {}

    public User(String dept, String nickName, String email, String passwd) {
        this.dept = dept;
        this.nickName = nickName;
        this.email = email;
        this.passwd = passwd;
    }
}
