package fb.blind.domain.article;

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

    @NotBlank
    String kindName;
    @NotBlank
    String title;
    @NotBlank
    String body;

}
