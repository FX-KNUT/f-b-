package fb.blind.kind.repository;

import fb.blind.domain.kind.Kind;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.*;

@Slf4j
@Repository
public class MemoryKindRepository implements KindRepository{

    private Map<Long,Kind> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Kind save(Kind kind) {
        if(kind.getId() == 0){
            kind.setId(++sequence);
        }

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
        log.info("repository Title = {} ", title);
        for (Kind kind : store.values()) {
            if(kind.getKindName().equals(title)){
                return Optional.ofNullable(kind);
            }
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
    

}
