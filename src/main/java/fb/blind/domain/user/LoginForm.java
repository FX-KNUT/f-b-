package fb.blind.domain.user;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Data
public class LoginForm {

    @NotBlank
    private String inputId;
    @NotBlank
    private String inputPw;

}
