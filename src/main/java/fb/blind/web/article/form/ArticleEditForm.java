package fb.blind.web.article.form;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class ArticleEditForm {
    /**
     * 게시판 수정
     */
    @NotBlank
    String title;
    @NotBlank
    String body;
    @NotNull
    long articleId;

}
