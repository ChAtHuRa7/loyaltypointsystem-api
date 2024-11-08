package com.abc.loyaltypointsystem.controller;


import com.abc.loyaltypointsystem.dtos.AddPointRequestDto;
import com.abc.loyaltypointsystem.dtos.CustomerCreateRequestDto;
import com.abc.loyaltypointsystem.entity.Customer;
import com.abc.loyaltypointsystem.servicers.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping("")
    public ResponseEntity<String> createCustomer(@RequestBody @Valid CustomerCreateRequestDto customerCreateRequestDto){
        customerService.createCustomer(customerCreateRequestDto);
        return new ResponseEntity<>("Customer created successfully.", HttpStatus.CREATED);
    }

    @GetMapping("")
    public  ResponseEntity<List<Customer>> getCustomers(){
        return new ResponseEntity<>(customerService.getAllCustomers(), HttpStatus.OK);
    }

    @PostMapping("/{cId}/points")
    public ResponseEntity<String> addPoints(@RequestBody @Valid AddPointRequestDto addPointRequestDto, @PathVariable("cId") long customerId){
        customerService.addPoints(addPointRequestDto, customerId);
        return new ResponseEntity<>("Points Added successfully.", HttpStatus.ACCEPTED);
    }

}
