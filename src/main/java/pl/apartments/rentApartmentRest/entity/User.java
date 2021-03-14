package pl.apartments.rentApartmentRest.entity;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import pl.apartments.rentApartmentRest.validator.UniqueEmail;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Entity
@Data
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @UniqueEmail
    private String username;

    private String firstName;

    private String firmName;

    private String lastName;

    private String password;

    private LocalDate created;

    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToOne(fetch = FetchType.EAGER, mappedBy = "tenantUser", cascade = CascadeType.REMOVE)
    private Apartment rentedHouse;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "ownerUser", cascade = CascadeType.REMOVE)
    private List<Apartment> auctions;

    private String nip;

    private String regon;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority(role.getAuthority()));
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
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
