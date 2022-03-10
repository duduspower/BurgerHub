package com.example.BurgerApp.Order;

import lombok.Data;
import org.hibernate.validator.constraints.CreditCardNumber;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
public class Order {

    @NotBlank(message = "Name is required!")
    private String name;

    @NotBlank(message = "Street is required!")
    private String street;

    @NotBlank(message = "City is required!")
    private String city;

    @NotBlank(message = "State is required!")
    private String state;

    @NotBlank(message = "Post Code is required!")
    private String postCode;

    @CreditCardNumber(message = "Not valid credit card number!")
    @NotBlank(message = "Credit card number is required!")
    private String creditNumber;

    @Pattern(regexp="^(0[1-9]|1[0-2])([\\/])([1-9][0-9])$", message="Must be formatted MM/YY")
    @NotBlank(message = "Credit card Expiration date is required!")
    private String creditExDate;

    @Digits(integer=3, fraction=0, message="Invalid CVV")
    @NotBlank(message = "Credit card CVV is required!")
    private String creditCVV;
}
