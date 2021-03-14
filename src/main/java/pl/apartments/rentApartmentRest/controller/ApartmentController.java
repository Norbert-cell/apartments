package pl.apartments.rentApartmentRest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.apartments.rentApartmentRest.entity.Apartment;
import pl.apartments.rentApartmentRest.service.ApartmentService;

import javax.validation.Valid;
import java.security.Principal;

@RestController
@RequestMapping("/apartment")
public class ApartmentController {

    private final ApartmentService apartmentService;

    @Autowired
    public ApartmentController(ApartmentService apartmentService) {
        this.apartmentService = apartmentService;
    }


    @GetMapping("/add")
    public void addApartment(Model model){
        model.addAttribute("apartment", new Apartment());
    }

    @PostMapping("/add")
    public Apartment saveApartment(@RequestBody Apartment apartment, Principal principal){
     return apartmentService.saveApartment(apartment, principal.getName());

    }
}
