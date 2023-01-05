package fb.blind;

import fb.blind.domain.profile.Profile;

import java.util.Optional;

public interface ProfileRepository {
    void save(Profile profile);
    Profile findByUserId(long userId);
    void delete(long userId);
}
