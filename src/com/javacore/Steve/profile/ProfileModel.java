package com.javacore.Steve.profile;

import com.javacore.Steve.common.BaseModel;

import java.util.Date;

/**
 * Contains data about one criminal profile.
 */
public class ProfileModel extends BaseModel {

    private int id;
    private String firstName;
    private String lastName;
    private String nickname;
    private int numberOfCrimes;
    private Date dateOfBirth;
    private boolean active;

    public ProfileModel(int id, String firstName, String lastName, boolean active) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.active = active;
    }

    /**
     * Creates random profile for testing.
     * @return Random model. Can be active or not active.
     */
    public static ProfileModel randomModel() {
        int rId = (int) (10 * Math.random());
        boolean rActive = rId % 2 == 0;
        String rFirstName = "Steve_" + rId;
        String rLastName = "Balmer" + rId;
        return new ProfileModel(rId, rFirstName, rLastName, rActive);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getName() {
        return firstName + " " + lastName;
    }
}
