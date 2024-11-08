package com.abc.loyaltypointsystem.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddPointRequestDto {

    @PositiveOrZero(message = "customer Id points must be positive")
    private long customerId;

    @Positive(message = "Loyalty points must be positive")
    private int points;
}
