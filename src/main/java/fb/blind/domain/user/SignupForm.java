package fb.blind.domain.user;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class SignupForm {

    @NotBlank
    @Size(min=2, max=5)
    private String nick;
    @NotBlank
    @Email
    private String email;
    @NotBlank
    @Size(min=8 , max=20)
    private String pw1;
    @NotBlank
    @Size(min=8 , max=20)
    private String pw2;
    @NotBlank
    @Size(min=2, max=20)
    private String dept;
    @NotBlank
    private String gender;
    @NotBlank
    private String question;
    @NotBlank
    @Size(min=1 , max=20)
    private String answer;
}
