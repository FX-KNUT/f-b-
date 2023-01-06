package fb.blind.profile.repository;

import fb.blind.domain.profile.Profile;

import java.util.Optional;

public interface ProfileRepository {
    /**
     * @param profile profile 객체 등록
     */
    Profile save(Profile profile);

    /**
     * @param userId user 고유 id
     * @return profile 반환
     */
    Profile findByUserId(long userId);

    /**
     * @param userId user 고유 id
     * user 삭제 -> profile 연쇄 삭제 필요
     */
    void delete(long userId);

    void clear();
}
