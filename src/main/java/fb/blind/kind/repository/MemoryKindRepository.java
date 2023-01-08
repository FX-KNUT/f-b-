package fb.blind.kind.repository;

import fb.blind.domain.kind.Kind;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.*;

@Repository
public class MemoryKindRepository implements KindRepository{

    private Map<Long,Kind> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Kind save(Kind kind) {
        kind.setId(++sequence);
        store.put(kind.getId(),kind);
        return kind;
    }

    @Override
    public List<Kind> findAll() {
        return new ArrayList<>(store.values());
    }

    @Override
    public Kind findById(long kindId) {
        return store.get(kindId);
    }

    @Override
    public Optional<Kind> findByTitle(String title) {
        for (Kind kind : store.values()) {
            if (kind.getKindName() == title)
                return Optional.ofNullable(kind);
        }
        return Optional.empty();
    }

    @Override
    public void removeKind(Kind kind) {
        store.remove(kind.getId());
    }

    @Override
    public void clear() {
        store.clear();
    }

    @PostConstruct
    public void setTestData(){
        Kind free = new Kind("자유게시판");
        Kind secret = new Kind("비밀게시판");
        Kind game = new Kind("게임게시판");
        Kind cat = new Kind("고양이게시판");

        free.setId(996L);
        secret.setId(997L);
        game.setId(998L);
        cat.setId(999L);

        store.put(free.getId(),free);
        store.put(secret.getId(),secret);
        store.put(game.getId(),game);
        store.put(cat.getId(),cat);

    }
}
