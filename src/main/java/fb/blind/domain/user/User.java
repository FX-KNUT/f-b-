package fb.blind.domain.user;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.domain.EntityScan;


@Getter
@Setter
@EntityScan

public class User {

    /**
     * @Param id : user 고유 id
     * @Param dept : 소속
     * @Param nickName : 닉네임
     * @Param email : 로그인 id -> e-mail 형식
     * @Param passwd : pw
     * @Param createDate : user  생성 시간
     */
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String dept;

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id=id;
    }
    public String getName(){
        return nickName;
    }
    public void setName(String nickName){
        this.nickName=nickName;
    }
    private String nickName;
    private String email;
    private String passwd;
    private String createDate;

    public User() {}

    public User(String dept, String nickName, String email, String passwd, String createDate) {
        this.dept = dept;
        this.nickName = nickName;
        this.email = email;
        this.passwd = passwd;
        this.createDate = createDate;
    }
}
