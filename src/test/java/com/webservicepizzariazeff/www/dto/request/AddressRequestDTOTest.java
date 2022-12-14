package com.webservicepizzariazeff.www.dto.request;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AddressRequestDTOTest {

    public AddressRequestDTO addressRequestDTO;

    @BeforeEach
    void setAddressRequestDTO(){

        this.addressRequestDTO = AddressRequestDTO.AddressRequestDTOBuilder.builder()
                .number("1")
                .road("road")
                .district("district")
                .city("city")
                .state("state")
                .build();
    }

    @Test
    void getNumber() {

        Assertions.assertThat(addressRequestDTO.getNumber())
                .isEqualTo("1");
    }

    @Test
    void getRoad() {

        Assertions.assertThat(addressRequestDTO.getRoad())
                .isEqualTo("road");
    }

    @Test
    void getDistrict() {

        Assertions.assertThat(addressRequestDTO.getDistrict())
                .isEqualTo("district");
    }

    @Test
    void getCity() {

        Assertions.assertThat(addressRequestDTO.getCity())
                .isEqualTo("city");
    }

    @Test
    void getState() {

        Assertions.assertThat(addressRequestDTO.getState())
                .isEqualTo("state");
    }

    @Test
    void testToString() {

        Assertions.assertThat(this.addressRequestDTO)
                .hasToString("AddressDTO{" +
                        "number='" + this.addressRequestDTO.getNumber() + '\'' +
                        ", road='" + this.addressRequestDTO.getRoad() + '\'' +
                        ", district='" + this.addressRequestDTO.getDistrict() + '\'' +
                        ", city='" + this.addressRequestDTO.getCity() + '\'' +
                        ", state='" + this.addressRequestDTO.getState() + '\'' +
                        '}');
    }
}