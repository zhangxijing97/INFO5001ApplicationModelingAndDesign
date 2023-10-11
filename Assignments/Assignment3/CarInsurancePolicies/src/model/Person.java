package model;

public class Person {
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private String socialSecurityNumber;
    private Address homeAddress;
    private Address workAddress;
    private Address localAddress;

    public Person(String firstName, String lastName, String dateOfBirth, String socialSecurityNumber,
            Address homeAddress, Address workAddress, Address localAddress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.socialSecurityNumber = socialSecurityNumber;
        this.homeAddress = homeAddress;
        this.workAddress = workAddress;
        this.localAddress = localAddress;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    public void setSocialSecurityNumber(String socialSecurityNumber) {
        this.socialSecurityNumber = socialSecurityNumber;
    }
    public void setHomeAddress(Address homeAddress) {
        this.homeAddress = homeAddress;
    }
    public void setWorkAddress(Address workAddress) {
        this.workAddress = workAddress;
    }
    public void setLocalAddress(Address localAddress) {
        this.localAddress = localAddress;
    }
    
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getDateOfBirth() {
        return dateOfBirth;
    }
    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }
    public Address getHomeAddress() {
        return homeAddress;
    }
    public Address getWorkAddress() {
        return workAddress;
    }
    public Address getLocalAddress() {
        return localAddress;
    }

    public void printInfo() {
        System.out.println("First Name: " + firstName);
        System.out.println("Last Name: " + lastName);
        System.out.println("Date Of Birth: " + dateOfBirth);
        System.out.println("Social Security Number: " + socialSecurityNumber);

        System.out.println("Home Address: ");
        homeAddress.printInfo();
        System.out.println("Work Address: ");
        workAddress.printInfo();
        System.out.println("Local Address: ");
        localAddress.printInfo();
    }
}
