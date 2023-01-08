package fb.blind.domain.article;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Article {

    /**
     * @Param id : 고유 no server binding
     * @Param title: 제목
     * @Param body : 내용
     * @Param date : 작성일
     * @Param fileName : file upload 시 file 경로 차후 구현 예정... 일단 경로만 가지고 있기로
     * @Param likes : 좋아요 수  server binding
     * @Param views : 조회 수 server binding
     * @Param userId  : 작성자 id 보관 server binding
     */
    private long id;
    private String title;
    private String body;
    private String date;
    private String fileName;
    private long likes;
    private long views;
    private long userId;
    private String writer;

    private long kindId;

    public Article(String testA, String test, String s, Object o, long l) {

    }

    public Article(String title, String body, String date, String fileName,String writer,long kindId) {
        this.title = title;
        this.body = body;
        this.date = date;
        this.fileName = fileName;
        this.writer = writer;
        this.kindId = kindId;
    }
}

