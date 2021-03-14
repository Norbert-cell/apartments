package pl.apartments.rentApartmentRest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.apartments.rentApartmentRest.converter.ApartmentDtoConverter;
import pl.apartments.rentApartmentRest.dto.ApartmentDto;
import pl.apartments.rentApartmentRest.entity.Apartment;
import pl.apartments.rentApartmentRest.service.ApartmentService;

import java.util.List;

@RestController
@RequestMapping("/app")
public class AppController {

    private final ApartmentService apartmentService;
    private final ApartmentDtoConverter apartmentDtoConverter;

    @Autowired
    public AppController(ApartmentService apartmentService, ApartmentDtoConverter apartmentDtoConverter) {
        this.apartmentService = apartmentService;
        this.apartmentDtoConverter = apartmentDtoConverter;
    }


    @GetMapping("/")
    public List<ApartmentDto> index(){
        List<Apartment> apartments = apartmentService.getAllApartmentsWhereRentedIsFalse();
        return apartmentDtoConverter.entityToDto(apartments);
    }
}
