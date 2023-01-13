package fb.blind.web.user.form;


import lombok.Data;

@Data
public class FindForm {
    private String email;
    private String question;
    private String answer;
}
