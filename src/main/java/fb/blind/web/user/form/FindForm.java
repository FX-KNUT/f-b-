package fb.blind.web.user.form;


import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class FindForm {

    private String email;

    private String question;

    private String answer;

}
