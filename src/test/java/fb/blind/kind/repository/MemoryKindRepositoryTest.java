package fb.blind.kind.repository;

import fb.blind.domain.kind.Kind;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

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
        free.setId(1L);
        Kind saved2 = kr.save(notice);
        notice.setId(2L);
        Kind findKind = kr.findById(1L);
        assertThat(findKind).isEqualTo(free);
    }

    @Test
    void findByTitle() {
        Kind free = new Kind("자유게시판");
        Kind notice = new Kind("공지");
        Kind saved1 = kr.save(free);
        Kind saved2 = kr.save(notice);
        Kind kind1 = kr.findByTitle("자유게시판").get();
        Kind kind2 = kr.findByTitle("공지").get();
        assertThat(kind1.getKindName()).isEqualTo("자유게시판");
        assertThat(kind2.getKindName()).isEqualTo("공지");
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