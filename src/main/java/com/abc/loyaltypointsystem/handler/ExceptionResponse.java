package com.abc.loyaltypointsystem.handler;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.Set;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(value = JsonInclude.Include.NON_EMPTY)
public class ExceptionResponse {

    private int errorCode;
    private String errorDescription;
    private Set<String> errorMessages;
}
