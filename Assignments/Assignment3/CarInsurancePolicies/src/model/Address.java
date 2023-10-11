package model;

public class Address {
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String zip;
    private String state;

    public Address(String addressLine1, String addressLine2, String city, String zip, String state) {
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.city = city;
        this.zip = zip;
        this.state = state;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }
    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public void setZip(String zip) {
        this.zip = zip;
    }
    public void setState(String state) {
        this.state = state;
    }

    public String getAddressLine1() {
        return addressLine1;
    }
    public String getAddressLine2() {
        return addressLine2;
    }
    public String getCity() {
        return city;
    }
    public String getZip() {
        return zip;
    }
    public String getState() {
        return state;
    }

    public void printInfo() {
        System.out.println("Address Line 1: " + addressLine1);
        System.out.println("Address Line 2: " + addressLine2);
        System.out.println("City: " + city);
        System.out.println("ZIP Code: " + zip);
        System.out.println("State: " + state);
    }
}
