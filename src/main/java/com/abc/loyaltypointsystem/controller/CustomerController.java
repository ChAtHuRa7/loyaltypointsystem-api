package com.abc.loyaltypointsystem.controller;


import com.abc.loyaltypointsystem.dtos.CustomerCreateRequestDto;
import com.abc.loyaltypointsystem.servicers.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping("")
    public ResponseEntity<String> createCustomer(@RequestBody @Valid CustomerCreateRequestDto customerCreateRequestDto){
        customerService.createCustomer(customerCreateRequestDto);
        return new ResponseEntity<>("Customer created successful.", HttpStatus.CREATED);
    }


}
