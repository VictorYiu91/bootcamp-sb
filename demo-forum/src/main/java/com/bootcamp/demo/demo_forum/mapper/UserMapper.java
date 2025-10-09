package com.bootcamp.demo.demo_forum.mapper;

import org.springframework.stereotype.Component;
import com.bootcamp.demo.demo_forum.dto.FullDataDto;
import com.bootcamp.demo.demo_forum.model.UserDTO;

// ! Bean
@Component // ! non-controller, non-service, non-repository
public class UserMapper {

  public FullDataDto map(UserDTO dto) {
    FullDataDto.AddressDto.GeoDto geoDto =
        FullDataDto.AddressDto.GeoDto.builder() //
            .lat(dto.getAddress().getGeo().getLat()) //
            .lng(dto.getAddress().getGeo().getLng()) //
            .build();

    FullDataDto.AddressDto addressDto = FullDataDto.AddressDto.builder() //
        .city(dto.getAddress().getCity()) //
        .street(dto.getAddress().getStreet()) //
        .zipcode(dto.getAddress().getZipcode()) //
        .suite(dto.getAddress().getSuite()) //
        .geo(geoDto) //
        .build();

    FullDataDto.CompanyDto companyDto = FullDataDto.CompanyDto.builder() //
        .bs(dto.getCompany().getBs()) //
        .catchPhrase(dto.getCompany().getCatchPhrase()) //
        .name(dto.getCompany().getName()) //
        .build();

    return FullDataDto.builder() //
        .id(dto.getId()) //
        .name(dto.getName()) //
        .username(dto.getUsername()) //
        .email(dto.getEmail()) //
        .address(addressDto) //
        .website(dto.getWebsite()) //
        .phone(dto.getPhone()) //
        .company(companyDto) //
        .build();
  }
}
