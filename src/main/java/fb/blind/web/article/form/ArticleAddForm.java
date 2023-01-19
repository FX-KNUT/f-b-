package fb.blind.web.article.form;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ArticleAddForm {
    /**
     * 게시판 새로 추가
     */
    @NotBlank
    String kindName;
    @NotBlank
    String title;
    @NotBlank
    String body;

}
