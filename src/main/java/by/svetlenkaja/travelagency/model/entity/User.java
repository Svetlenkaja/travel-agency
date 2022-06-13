package by.svetlenkaja.travelagency.model.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Table (name = "user")
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "role_type", referencedColumnName = "type"),
            @JoinColumn(name = "role_code", referencedColumnName = "code")
    })
    private Classifier role;
    @Column (name = "surname")
    private String surname;
    @Column (name = "name")
    private String name;
    @Column
    private String email;
    @Column(name = "login")
    private String login;
    @Column(name="password")
    private String password;
    @Transient
    private String passwordConfirm;
}
