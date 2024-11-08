package com.abc.loyaltypointsystem.dtos;

import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerCreateRequestDto {

    @NotBlank(message = "Name is required")
    private String firstName;

    private String LastName;

    @NotBlank(message = "Email is required")
    @Email(message = "Incorrect email format")
    private String email;

    @NotBlank(message = "Phone number is required")
    private String phoneNumber;

    @NotBlank(message = "Address is required")
    private String address;


}
