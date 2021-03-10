package pl.apartments.rentApartmentRest.controller;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.apartments.rentApartmentRest.entity.Role;
import pl.apartments.rentApartmentRest.entity.User;
import pl.apartments.rentApartmentRest.service.UserService;

import javax.validation.Valid;

import static pl.apartments.rentApartmentRest.entity.Role.ROLE_USER;

@RestController
public class AuthenticatedController {

    private final UserService userService;

    public AuthenticatedController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/login")
    public void login(){
    }

    @GetMapping("/registry")
    public void registry(Model model){
        model.addAttribute("user", new User());
    }


    @PostMapping("/registry")
    public User registry(@RequestBody @Valid User user, BindingResult result){
        if (result.hasErrors()){
            return new User();
        }
        user.setRole(ROLE_USER);
        userService.save(user);
    return user;
    }


}
