package fb.blind.domain.user;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class SignupForm {

    @NotBlank
    private String nick;
    @NotBlank
    private String id;
    @NotBlank
    private String pw1;
    @NotBlank
    private String pw2;
    @NotBlank
    private String dept;
    @NotBlank
    private String gender;
    @NotBlank
    private String question;
    @NotBlank
    private String answer;
}
