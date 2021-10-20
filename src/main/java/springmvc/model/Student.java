package springmvc.model;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Student
{
    private String firstName;
    @NotNull(message = "is required")
    @Size(min=1, message="is required")
    private String lastName;
    private String country;
    private String favouriteLanguage;


    public String getFavouriteLanguage() {
        return favouriteLanguage;
    }

    public void setFavouriteLanguage(String favouriteLanguage) {
        this.favouriteLanguage = favouriteLanguage;
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
