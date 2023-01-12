package fb.blind.domain.kind.service;

import fb.blind.domain.kind.Kind;

import java.util.List;
import java.util.Optional;

public interface KindService {

    Kind add(Kind kind);

    Optional<Kind> getKindById(long kindId);

    Optional<Kind> getKindByTitle(String title);

    List<Kind> findAll();

    Optional<Kind> findByTitle(String title);

    void delete(Kind kind);

}
