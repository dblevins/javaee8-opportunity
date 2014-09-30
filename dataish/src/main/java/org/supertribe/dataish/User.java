package org.supertribe.dataish;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;

@Entity
@NamedQueries({
        @javax.persistence.NamedQuery(name = User.FIND_BY_USERNAME, query = "SELECT u FROM User u WHERE u.username = :username"),
        @javax.persistence.NamedQuery(name = User.FIND_BY_FIRSTNAME, query = "SELECT u FROM User u WHERE u.firstname = :firstname"),
        @javax.persistence.NamedQuery(name = User.FIND_BY_LASTNAME, query = "SELECT u FROM User u WHERE u.lastname = :lastname"),
        @javax.persistence.NamedQuery(name = User.FIND_ALL, query = "SELECT p FROM User p")
})
public class User {

    @Id
    @GeneratedValue
    private long id;

    private String username;
    private String firstname;
    private String lastname;

    public static final String FIND_BY_USERNAME = "User.findByUsername";
    public static final String FIND_BY_FIRSTNAME = "User.findByFirstname";
    public static final String FIND_BY_LASTNAME = "User.findByLastname";
    public static final String FIND_ALL = "User.findAll";

    public User() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User(String username, String firstname, String lastname) {
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
}
