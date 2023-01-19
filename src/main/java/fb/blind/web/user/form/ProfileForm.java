package fb.blind.web.user.form;

import fb.blind.domain.Gender;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
public class ProfileForm {

    @NotBlank
    @Size(min=2, max=5)
    private String nickName;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    @Size(min=2, max=20)
    private String dept;

    @NotBlank
    private String gender;
}
