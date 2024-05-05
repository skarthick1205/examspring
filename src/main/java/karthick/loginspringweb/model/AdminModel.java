package karthick.loginspringweb.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name="admin")
public class AdminModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String code;
    String name;
    String eligibility;
    Integer fees;

    public AdminModel() {
    }

    public AdminModel(Integer id, String code, String name, String eligibility, Integer fees) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.eligibility = eligibility;
        this.fees = fees;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEligibility() {
        return eligibility;
    }

    public void setEligibility(String eligibility) {
        this.eligibility = eligibility;
    }

    public Integer getFees() {
        return fees;
    }

    public void setFees(Integer fees) {
        this.fees = fees;
    }
}