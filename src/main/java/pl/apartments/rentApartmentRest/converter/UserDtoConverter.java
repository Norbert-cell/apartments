package pl.apartments.rentApartmentRest.converter;

import org.springframework.stereotype.Component;
import pl.apartments.rentApartmentRest.dto.UserDto;
import pl.apartments.rentApartmentRest.entity.User;

@Component
public class UserDtoConverter {

    public UserDto entityToDto(User user){

        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setUsername(user.getUsername());
        userDto.setPassword(user.getPassword());
        userDto.setRole(user.getRole());

        return userDto;
    }

    public User dtoToEntity(UserDto userDto){

        User user = new User();

        user.setId(userDto.getId());
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        user.setRole(userDto.getRole());

        return user;
    }

}
