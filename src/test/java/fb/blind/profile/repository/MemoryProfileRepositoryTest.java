package fb.blind.profile.repository;

import fb.blind.domain.Gender;
import fb.blind.domain.profile.Profile;
import fb.blind.domain.profile.repository.MemoryProfileRepository;
import fb.blind.domain.profile.repository.ProfileRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class MemoryProfileRepositoryTest {

    private ProfileRepository pr = new MemoryProfileRepository();

    @AfterEach
    public void afterEach(){
        pr.clear();
    }
    @Test
    void save() {
        Profile profile = pr.save(new Profile(Gender.M, "path", 1L));
        assertThat(profile.getImgPath()).isEqualTo("path");
    }

    @Test
    void findByUserId() {
        Profile saved = pr.save(new Profile(Gender.M, "path", 1L));
        Profile profile = pr.findByUserId(1L);
        assertThat(profile.getImgPath()).isEqualTo(saved.getImgPath());
    }

    @Test
    void delete() {
        pr.save(new Profile(Gender.M, "path", 1L));
        pr.delete(1L);
        assertThat(pr.findByUserId(1L)).isNull();
    }

}