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
    private Date placeOfBirth;
    private Date dateOfDeath;
    private String placeOfDeath;
    private String criminalFamily;
    private String dNA;
    private String description;
    private boolean deceased;

    public ProfileModel(int id, String firstName, String lastName, String nickname, int numberOfCrimes, Date dateOfBirth, Date placeOfBirth, boolean deceased, Date dateOfDeath, String description) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.nickname = nickname;
        this.numberOfCrimes = numberOfCrimes;
        this.dateOfBirth = dateOfBirth;
        this.placeOfBirth = placeOfBirth;
        this.deceased = deceased;
        this.dateOfDeath = dateOfDeath;
        this.placeOfDeath = placeOfDeath;
        this.criminalFamily = criminalFamily;
        this.dNA = dNA;
        this.description = description;
    }

    /**
     * Creates random profile for testing.
     * @return Random model. Can be active or not active.
     */
//    public static ProfileModel randomModel() {
//        int rId = (int) (10 * Math.random());
//        boolean rActive = rId % 2 == 0;
//        String rFirstName = "Steve_" + rId;
//        String rLastName = "Balmer" + rId;
//        return new ProfileModel(rId, rFirstName, rLastName, rActive);
//    }

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

    public String getName() {
        return firstName + " " + lastName;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getNumberOfCrimes() {
        return numberOfCrimes;
    }

    public void setNumberOfCrimes(int numberOfCrimes) {
        this.numberOfCrimes = numberOfCrimes;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Date getPlaceOfBirth() {
        return placeOfBirth;
    }

    public void setPlaceOfBirth(Date placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    }

    public Date getDateOfDeath() {
        return dateOfDeath;
    }

    public void setDateOfDeath(Date dateOfDeath) {
        this.dateOfDeath = dateOfDeath;
    }

    public String getPlaceOfDeath() {
        return placeOfDeath;
    }

    public void setPlaceOfDeath(String placeOfDeath) {
        this.placeOfDeath = placeOfDeath;
    }

    public String getCriminalFamily() {
        return criminalFamily;
    }

    public void setCriminalFamily(String criminalFamily) {
        this.criminalFamily = criminalFamily;
    }

    public String getdNA() {
        return dNA;
    }

    public void setdNA(String dNA) {
        this.dNA = dNA;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isDeceased() {
        return deceased;
    }

    public void setDeceased(boolean deceased) {
        this.deceased = deceased;
    }
}
