package br.com.southrocklab.dto;


import br.com.southrocklab.domain.Brand;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.*;

@ApiModel
public class CardDTO {

    @ApiModelProperty(
        value = "Id of card.",
        dataType = "int"
    )
    @NotNull(message = "CustomerId cannot be null")
    private Integer customerId;

    @ApiModelProperty(
        value = "Number of card.",
        dataType = "int",
        required = true
    )
    @NotNull(message = "Number cannot be null")
    @Size(min = 16, max = 16, message = "Number must have a 16 numbers")
    private String number;

    @ApiModelProperty(
        value = "Holder name of card.",
        dataType = "String",
        required = true
    )
    @NotEmpty(message = "Holder name cannot be empty")
    @Size(min = 5, max = 20, message = "Holder name must have a minimum of 5 character and a maximum of 20 characters")
    private String holderName;

    @ApiModelProperty(
        value = "Brand of card.",
        dataType = "String",
        allowableValues = "MASTER, VISA, ELO",
        required = true
    )
    @NotNull(message = "Brand cannot be null")
    private Brand brand;

    @ApiModelProperty(
        value = "Expiration month of card.",
        dataType = "int",
        required = true
    )
    @NotNull(message = "Expiration month cannot be null")
    @Min(value = 1, message = "Expiration month must be greater then 1")
    @Max(value = 12, message = "Expiration month must be less then 12")
    private Integer expirationMoth;

    @ApiModelProperty(
        value = "Expiration year of card.",
        dataType = "int",
        required = true
    )
    @NotNull(message = "Expiration year cannot be null")
    @Min(value = 2022, message = "Expiration year must be greater than the current one")
    private Integer expirationYear;

    @ApiModelProperty(
        value = "Security code of card.",
        dataType = "string",
        required = true
    )
    @NotNull(message = "cvc cannot be null")
    @Size(min = 3, max = 3, message = "cvc must be between 001 to 999")
    private String cvc;

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getHolderName() {
        return holderName;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Integer getExpirationMoth() {
        return expirationMoth;
    }

    public void setExpirationMoth(Integer expirationMoth) {
        this.expirationMoth = expirationMoth;
    }

    public Integer getExpirationYear() {
        return expirationYear;
    }

    public void setExpirationYear(Integer expirationYear) {
        this.expirationYear = expirationYear;
    }

    public String getCvc() {
        return cvc;
    }

    public void setCvc(String cvc) {
        this.cvc = cvc;
    }
}
