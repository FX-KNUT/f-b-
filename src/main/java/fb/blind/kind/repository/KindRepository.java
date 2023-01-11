package fb.blind.kind.repository;

import fb.blind.domain.kind.Kind;

import java.util.List;
import java.util.Optional;

public interface KindRepository {

    Kind save(Kind kind);

    List<Kind> findAll();

    Kind findById(long kindId);

    void removeKind(Kind kind);

    void clear();

}
