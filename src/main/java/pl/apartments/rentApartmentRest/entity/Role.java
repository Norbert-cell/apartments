package pl.apartments.rentApartmentRest.entity;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {

    ROLE_ADMIN,
    ROLE_USER,
    ROLE_FIRM;

    @Override
    public String getAuthority() {
        return this.name();
    }
}
