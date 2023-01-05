package fb.blind.domain.profile;

import fb.blind.domain.Gender;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Profile {

    /**
     * id : profiel 고유 no
     * gender : 여 0, 남 1 (Enum)
     * imgPath : 경로 저장용
     * userId : user id
     */
    private long id;
    private Gender gender;
    private String imgPath;
    private long userId;

    public Profile(Gender gender, String imgPath, long userId) {
        this.gender = gender;
        this.imgPath = imgPath;
        this.userId = userId;
    }
}
