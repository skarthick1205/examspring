package karthick.loginspringweb.model;

import jakarta.persistence.*;

@Entity
@Table(name = "apply")
public class ApplyModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String name;
    String dob;
    String gender;
    String address;
    String examcode;
    String centre;
    String language;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getExamcode() {
        return examcode;
    }

    public void setExamcode(String examcode) {
        this.examcode = examcode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
       this.address = address;
    }

    public String getCentre() {
        return centre;
    }

    public void setCentre(String centre) {
        this.centre = centre;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Override
    public String toString() {
        return "ApplyModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dob='" + dob + '\'' +
                ", gender='" + gender + '\'' +
                ", address='" + address + '\'' +
                ", examcode='" + examcode + '\'' +
                ", centre='" + centre + '\'' +
                ", language='" + language + '\'' +
                '}';
    }
}
