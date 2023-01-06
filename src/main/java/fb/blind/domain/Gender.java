package fb.blind.domain;

import lombok.Getter;

@Getter
public enum Gender {

    M(0),W(1);
    private int gender;

    /**
     * @param gender M -> 0 , W -> 1
     */
    Gender(int gender) {
        this.gender = gender;
    }

}
