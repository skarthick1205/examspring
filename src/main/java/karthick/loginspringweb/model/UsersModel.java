package karthick.loginspringweb.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name="userss")
public class UsersModel {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    Integer id;
    String username;
    String emailid;
    String password;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmailid() {
        return emailid;
    }

    public void setEmailid(String emailid) {
        this.emailid = emailid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsersModel that = (UsersModel) o;
        return Objects.equals(id, that.id) && Objects.equals(username, that.username) && Objects.equals(emailid, that.emailid) && Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, emailid, password);
    }

    @Override
    public String toString() {
        return "UsersModel{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", emailid='" + emailid + '\'' +
                '}';
    }
}
