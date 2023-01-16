package fb.blind.kind.repository;

import fb.blind.domain.kind.Kind;
import fb.blind.domain.kind.repository.KindRepository;
import fb.blind.domain.kind.repository.MemoryKindRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class MemoryKindRepositoryTest {

    private KindRepository kr = new MemoryKindRepository();

    @AfterEach
    public void afterEach(){
        kr.clear();
    }
    @Test
    void save() {
        Kind free = new Kind("자유게시판");
        Kind saved = kr.save(free);
        assertThat(saved).isEqualTo(free);
    }

    @Test
    void findAll() {
        Kind free = new Kind("자유게시판");
        Kind notice = new Kind("공지");
        Kind saved1 = kr.save(free);
        Kind saved2 = kr.save(notice);
        List<Kind> s = new ArrayList<>();
        s.add(saved1); s.add(saved2);
        assertThat(s).contains(saved1,saved2);

    }

    @Test
    void findById() {
        Kind free = new Kind("자유게시판");
        Kind notice = new Kind("공지");
        Kind saved1 = kr.save(free);
        System.out.println("saved1.getId() = " + saved1.getId());
        Kind saved2 = kr.save(notice);
        System.out.println("saved2.getId() = " + saved2.getId());

        Kind findKind = kr.findById(3L);
        assertThat(findKind).isEqualTo(free);
    }

    @Test
    void removeKind() {
        Kind free = new Kind("자유게시판");
        Kind notice = new Kind("공지");
        Kind saved1 = kr.save(free);
        Kind saved2 = kr.save(notice);
        List<Kind> s = new ArrayList<>();
        s.add(saved1); s.add(saved2);
        kr.removeKind(saved1);
        List<Kind> result = kr.findAll();
        assertThat(result).doesNotContain(free);
        assertThat(result).contains(notice);
    }

}