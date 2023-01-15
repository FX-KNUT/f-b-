package fb.blind.domain.kind.repository;

import fb.blind.domain.kind.Kind;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.*;

@Slf4j
@Repository
public class MemoryKindRepository implements KindRepository{

    private static Map<Long,Kind> store = new HashMap<>();
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
    public void removeKind(Kind kind) {
        store.remove(kind.getId());
    }

    @Override
    public void clear() {
        store.clear();
    }
    

}
