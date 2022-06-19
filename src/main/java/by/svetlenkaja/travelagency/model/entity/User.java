package by.svetlenkaja.travelagency.model.entity;

import by.svetlenkaja.travelagency.constant.RoleType;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Data
@Table (name = "user")
@Entity
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "username")
    private String username;
    @Column (name = "surname")
    private String surname;
    @Column (name = "name")
    private String name;
    @Column
    private String email;
    @Column(name="password")
    private String password;
    @Transient
    private String passwordConfirm;
    @Column(name = "account_non_locked")
    private boolean accountNonLocked;
    @Enumerated(EnumType.STRING)
    @ElementCollection(fetch = FetchType.EAGER)
    private List<RoleType> roles;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> grantList= new ArrayList<GrantedAuthority>();
        if(roles!= null)  {
            roles.forEach(role ->
                    grantList.add(new SimpleGrantedAuthority(role.toString())));
            }
        return grantList;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
