package pl.apartments.rentApartmentRest.dto;

import lombok.Data;
import pl.apartments.rentApartmentRest.entity.Role;

@Data
public class UserDto {

    private long id;
    private String username;
    private String password;
    private Role role;
}
