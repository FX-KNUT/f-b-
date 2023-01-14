package fb.blind.web.user.form;


import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class EditPwForm {

    @NotBlank
    private String pw1;
    @NotBlank
    private String pw2;

}
