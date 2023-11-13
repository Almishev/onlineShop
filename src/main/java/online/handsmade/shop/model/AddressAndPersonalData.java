package online.handsmade.shop.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
public class AddressAndPersonalData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @NotEmpty(message = "Enter name")
    @Size(min = 2, message = "Min two symbols")
    @Size(max = 30, message = "Max 30 symbols")
    private String firstName;
    @NotBlank
    @NotEmpty(message = "Enter lastname")
    @Size(min = 2, message = "Min two symbols")
    @Size(max = 30, message = "Max 30 symbols")
    private String lastName;
    @NotBlank
    @NotEmpty(message = "Enter city")
    @Size(min = 2, message = "Min two symbols")
    @Size(max = 30, message = "Max 30 symbols")
    private String city;
    @NotBlank
    @NotEmpty(message = "Enter street")
    @Size(min = 2, message = "Min two symbols")
    @Size(max = 30, message = "Max 30 symbols")
    private String street;
    @NotBlank
    @NotEmpty(message = "Enter post code")
    @Size(min = 2, message = "Min two symbols")
    @Size(max = 30, message = "Max 30 symbols")
    private String zipCode;
    @NotBlank
    @NotEmpty(message = "Enter phone number")
    @Size(min = 10, message = "Phone must be 10 digits")
    @Size(max = 10, message = "Phone must be 10 digits")
    private String phoneNumber;

    public AddressAndPersonalData(String firstName, String lastName, String city, String street, String zipCode, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.city = city;
        this.street = street;
        this.zipCode = zipCode;
        this.phoneNumber=phoneNumber;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public AddressAndPersonalData() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZipPost() {
        return zipCode;
    }

    public void setZipPost(String zipPost) {
        this.zipCode = zipPost;
    }
}
