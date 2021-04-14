package com.testresume.entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "resume")
public class Resume {

    @Id
    private ObjectId id;

    @Indexed
    private String uid;
    private String firstName;
    private String lastName;
    private String middleName;
    private String city;
    private String email;
    private String phone;
    private String skills;
    private String experience;
    private String objective;


    public Resume(String firstName, String lastName, String middleName, String city, String email, String phone, String skills, String experience, String objective) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.city = city;
        this.email = email;
        this.phone = phone;
        this.skills = skills;
        this.experience = experience;
        this.objective = objective;

    }

    public ObjectId getId() { return id; }

    public String getUid() { return uid; }
    public void setUid(String uid) { this.uid = uid; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getMiddleName() { return middleName; }
    public void setMiddleName(String middleName) { this.middleName = middleName; }

    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getSkills() { return skills; }
    public void setSkills(String skills) { this.skills = skills; }

    public String getExperience() { return experience; }
    public void setExperience(String experience) { this.experience = experience; }

    public String getObjective() { return objective; }
    public void setObjective(String objective) { this.objective = objective; }

    @Override
    public String toString() {
        return "Resume{" +
                "uid='" + uid + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", city='" + city + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", skills='" + skills + '\'' +
                ", experience='" + experience + '\'' +
                ", objective='" + objective + '\'' +
                '}';
    }
}
