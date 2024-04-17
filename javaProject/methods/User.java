package javaProject.methods;

public class User {
    private String username;
    private String password;
    private String name;
    private String address;
    private String phoneNumber;
    private String email;
    private String favoriteAnimal;

    public User(
            String username,
            String password,
            String name,
            String address,
            String phoneNumber,
            String email,
            String favoriteAnimal
    ) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.favoriteAnimal = favoriteAnimal;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getFavoriteAnimal() {
        return favoriteAnimal;
    }
}
