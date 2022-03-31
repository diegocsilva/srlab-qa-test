package br.com.southrocklab.dto;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.time.LocalDate;

public class CustomerDTO {

    @ApiModelProperty(
        value = "Name of customer.",
        dataType = "String",
        required = true
    )
    @NotEmpty(message = "Name cannot be empty")
    @Size(min = 1, max = 50, message = "Name must have a minimum of 1 character and a maximum of 50 characters")
    private String name;

    @ApiModelProperty(
        value = "Last name of customer.",
        dataType = "String",
        required = true
    )
    @NotEmpty(message = "Last name cannot be empty")
    @Size(min = 1, max = 50, message = "Last name must have a minimum of 1 character and a maximum of 50 characters")
    private String lastName;

    @ApiModelProperty(
        value = "Birth date of customer.",
        dataType = "String",
        required = true
    )
    @NotNull(message = "Birth date cannot be null")
    @Past(message = "Birth date must be smaller than today")
    private LocalDate birthDate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

}
