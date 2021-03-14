package pl.apartments.rentApartmentRest.converter;

import org.springframework.stereotype.Component;
import pl.apartments.rentApartmentRest.dto.ApartmentDto;
import pl.apartments.rentApartmentRest.entity.Apartment;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ApartmentDtoConverter {

    public ApartmentDto entityToDto(Apartment apartment){

        ApartmentDto apartmentDto = new ApartmentDto();
        apartmentDto.setId(apartment.getId());
        apartmentDto.setTitle(apartment.getTitle());
        apartmentDto.setContent(apartment.getContent());
        apartmentDto.setCreated(apartment.getCreated());
        apartmentDto.setApartmentArea(apartment.getApartmentArea());
        apartmentDto.setPrice(apartment.getPrice());
        apartmentDto.setRented(apartment.isRented());
        apartmentDto.setRooms(apartment.getRooms());

        return apartmentDto;
    }

    public Apartment dtoToEntity(ApartmentDto apartmentDto){

        Apartment apartment = new Apartment();
        apartment.setId(apartmentDto.getId());
        apartment.setTitle(apartmentDto.getTitle());
        apartment.setContent(apartmentDto.getContent());
        apartment.setCreated(apartmentDto.getCreated());
        apartment.setApartmentArea(apartmentDto.getApartmentArea());
        apartment.setPrice(apartmentDto.getPrice());
        apartment.setRented(apartmentDto.isRented());
        apartment.setRooms(apartmentDto.getRooms());

        return apartment;
    }

    public List<ApartmentDto>  entityToDto(List<Apartment> apartments){

        return apartments.stream().map(this::entityToDto).collect(Collectors.toList());
    }

    public List<Apartment> dtoToEntity(List<ApartmentDto> apartmentDtos){

        return apartmentDtos.stream().map(this::dtoToEntity).collect(Collectors.toList());
    }
}
