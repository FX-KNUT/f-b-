package fb.blind.domain.profile;

import fb.blind.domain.Gender;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Profile {

    /**
     * @Param id : profile 고유 no
     * @Param gender : 여 0, 남 1 (Enum)
     * @Param imgPath : 경로 저장용
     * @Param userId : user id
     */
    private long id;
    private Gender gender;
    private String imgPath;
    private long userId;

    public Profile() {}

    public Profile(Gender gender, String imgPath, long userId) {
        this.gender = gender;
        this.imgPath = imgPath;
        this.userId = userId;
    }
}
