package fb.blind.kind.service;

import fb.blind.domain.kind.Kind;
import fb.blind.kind.repository.KindRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class KindServiceImpl implements KindService{

    private final KindRepository kr;

    @Autowired
    public KindServiceImpl(KindRepository kr) {
        this.kr = kr;
    }

    @Override
    public Kind add(Kind kind) {
        return kr.save(kind);
    }

    @Override
    public Optional<Kind> getKindById(long kindId) {
        return Optional.ofNullable(kr.findById(kindId));
    }

    @Override
    public Optional<Kind> getKindByTitle(String title) {
        return findByTitle(title);
    }

    @Override
    public List<Kind> findAll() {
        return kr.findAll();
    }

    @Override
    public void delete(Kind kind) {
        kr.removeKind(kind);
    }

    @Override
    public Optional<Kind> findByTitle(String title) {
        log.info("repository Title = {} ", title);
        return kr.findAll().stream().filter(m -> m.getKindName().equals(title)).findFirst();
    }

}
