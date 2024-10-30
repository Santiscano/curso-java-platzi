public class User {
    private int id;
    private String name;
    private String email;
    private String address;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getDataUser() {
        return "Nombre: " + this.name + ", Email: " + this.email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    private String phoneNumber;
}
