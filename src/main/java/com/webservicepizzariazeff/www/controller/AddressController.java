package com.webservicepizzariazeff.www.controller;

import com.webservicepizzariazeff.www.dto.request.AddressDTO;
import com.webservicepizzariazeff.www.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "addresses")
public class AddressController {

    private final AddressService addressService;

    @Autowired
    protected AddressController(AddressService addressService) {

        this.addressService = addressService;
    }

    @PutMapping(
            value = "register",
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Long> registerNewAddress(
            @AuthenticationPrincipal UserDetails userDetails,
            @RequestBody @Valid AddressDTO addressDTO,
            @RequestHeader(value = "Accept-Language") String acceptLanguage
    ) {

        return new ResponseEntity<>(this.addressService.registerAddress(userDetails, addressDTO, acceptLanguage), HttpStatus.CREATED);
    }
}
