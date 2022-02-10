package com.example.springBootDemo.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Component
@Setter
@Getter
public class EmployeeDTO {

    @NotNull(message = "id cant be null")
    private Integer id;

    @Size(max = 10, message = "cant be greated than 10")
    @JsonProperty(value = "name")
    private String name;

    @JsonProperty(value = "location")
    private String city;
}
