package com.example.springBootDemo.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.Date;

@Getter
@Setter
@Component
@NoArgsConstructor
@AllArgsConstructor
public class ErrorDetails {
    private Date timestamp;
    private String message;
    private String details;


}
