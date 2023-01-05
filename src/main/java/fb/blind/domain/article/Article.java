package fb.blind.domain.article;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Article {

    /**
     * id : 고유 no server binding
     * title: 제목
     * body : 내용
     * date : 작성일
     * fileName : file upload 시 file 경로 차후 구현 예정... 일단 경로만 가지고 있기로
     * likes : 좋아요 수  server binding
     * views : 조회 수 server binding
     * userId  : 작성자 id 보관 server binding
     */
    private long id;
    private String title;
    private String body;
    private String date;
    private String fileName;
    private long likes;
    private long views;
    private long userId;

    public Article(String title, String body, String date, String fileName) {
        this.title = title;
        this.body = body;
        this.date = date;
        this.fileName = fileName;
    }
}

