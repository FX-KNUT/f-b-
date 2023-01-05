package fb.blind.domain.user;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {

    /**
     * id : user 고유 id
     * depf : 소속
     * nickName : 닉네임
     * email : 로그인 id -> e-mail 형식
     * passwd : pw
     * createDate : user  생성 시간
     */
    private long id;
    private String dept;
    private String nickName;
    private String email;
    private String passwd;
    private String createDate;

    public User(String dept, String nickName, String email, String passwd, String createDate) {
        this.dept = dept;
        this.nickName = nickName;
        this.email = email;
        this.passwd = passwd;
        this.createDate = createDate;
    }
}
