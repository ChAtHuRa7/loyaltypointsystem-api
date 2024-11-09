package com.abc.loyaltypointsystem.controller;


import com.abc.loyaltypointsystem.dtos.CustomerCreateRequestDto;
import com.abc.loyaltypointsystem.dtos.PointUpdateRequestDto;
import com.abc.loyaltypointsystem.entity.Customer;
import com.abc.loyaltypointsystem.servicers.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping("")
    public ResponseEntity<Customer> createCustomer(@RequestBody @Valid CustomerCreateRequestDto customerCreateRequestDto){
        Customer newCustomer = customerService.createCustomer(customerCreateRequestDto);
        return new ResponseEntity<>(newCustomer, HttpStatus.CREATED);
    }

    @GetMapping("")
    public  ResponseEntity<List<Customer>> getCustomers(){
        return new ResponseEntity<>(customerService.getAllCustomers(), HttpStatus.OK);
    }

    @PostMapping("/{cId}/points")
    public ResponseEntity<String> addPoints(@RequestBody @Valid PointUpdateRequestDto pointUpdateRequestDto, @PathVariable("cId") long customerId){
        customerService.addPoints(pointUpdateRequestDto, customerId);
        return new ResponseEntity<>("Points Added successfully.", HttpStatus.ACCEPTED);
    }

    @PostMapping("/{cId}/redeem")
    public ResponseEntity<String> redeemPoints(@RequestBody @Valid PointUpdateRequestDto pointUpdateRequestDto, @PathVariable("cId") long customerId){
        customerService.redeemPoints(pointUpdateRequestDto, customerId);
        return new ResponseEntity<>("Points redeem successfully.", HttpStatus.ACCEPTED);
    }

}
