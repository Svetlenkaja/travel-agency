package by.svetlenkaja.travelagency.model.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "role_type", referencedColumnName = "type"),
            @JoinColumn(name = "role_code", referencedColumnName = "code")
    })
    private Classifier role;

    @Column
    private String surname;
    @Column
    private String name;
    @Column
    private String patronymic;
    @Column
    private String login;
    @Column
    private String password;
    @Transient
    private String passwordConfirm;
}
