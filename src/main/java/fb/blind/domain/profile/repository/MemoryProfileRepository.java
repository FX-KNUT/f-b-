package fb.blind.domain.profile.repository;

import fb.blind.domain.profile.Profile;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class MemoryProfileRepository implements ProfileRepository{

    private static Map<Long,Profile> store = new HashMap<>();

    @Override
    public Profile save(Profile profile) {
        store.put(profile.getUserId(), profile);
        return profile;
    }

    @Override
    public Profile findByUserId(long userId) {
        return store.get(userId);
    }

    @Override
    public void delete(long userId) {
        store.remove(userId);
    }

    @Override
    public void clear() {
        store.clear();
    }

}
