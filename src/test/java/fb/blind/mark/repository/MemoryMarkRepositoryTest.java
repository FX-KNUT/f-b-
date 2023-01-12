package fb.blind.mark.repository;

import fb.blind.domain.mark.Mark;
import fb.blind.domain.mark.repository.MarkRepository;
import fb.blind.domain.mark.repository.MemoryMarkRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class MemoryMarkRepositoryTest {

    private final MarkRepository mr = new MemoryMarkRepository();

    Mark mark1;
    Mark mark2;
    Mark mark3;
    Mark mark4;
    Mark mark5;
    Mark mark6;

    Mark mark7;
    Mark mark8;

    @AfterEach
    public void afterEach(){
        mr.clear();
    }

    @BeforeEach
    public void beforeEach(){

        mark1 = new Mark(1L, 1L, "mark1");
        mark4 = new Mark(4L, 1L, "mark4");

        mark7 = new Mark(4L, 2L, "mark7");
        mark8 = new Mark(4L, 3L, "mark9");

        mark5 = new Mark(5L, 1L, "mark5");
        mark6 = new Mark(6L, 1L, "mark6");
        mark2 = new Mark(2L, 2L, "mark2");
        mark3 = new Mark(3L, 3L, "mark3");

        mark1.setId(1L);
        mark2.setId(2L);
        mark3.setId(3L);
        mark4.setId(4L);
        mark5.setId(5L);
        mark6.setId(6L);
        mark7.setId(7L);
        mark8.setId(8L);

        mr.save(mark1);
        mr.save(mark2);
        mr.save(mark3);
        mr.save(mark4);
        mr.save(mark5);
        mr.save(mark6);
        mr.save(mark7);
        mr.save(mark8);
    }
    @Test
    void save() {
        Mark markA = new Mark(999L, 999L, "mark999");
        Mark mark = mr.save(markA);
        assertThat(mark.getName()).isEqualTo("mark999");
    }

    @Test
    void findByUserId() {
        List<Mark> mark = mr.findByUserId(1L);
        assertThat(mark).contains(mark1,mark4,mark5,mark6);
    }

    @Test
    void delete() {
        mr.delete(mark4);
        List<Mark> result = mr.findByUserId(1L);
        assertThat(result).doesNotContain(mark4);
    }

    @Test
    void 아티클아이디(){
        List<Mark> articles = mr.findByArticleId(4L);
        assertThat(articles).contains(mark4,mark7,mark8);
    }

}