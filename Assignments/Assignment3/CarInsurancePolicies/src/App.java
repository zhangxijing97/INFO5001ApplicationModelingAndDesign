import java.util.Arrays;
import model.Address;
import model.Car;
import model.InsurancePolicyRegister;
import model.Person;

public class App {
    public static void main(String[] args) throws Exception {

        // Create an InsurancePolicyRegister instance
        InsurancePolicyRegister policyRegister = new InsurancePolicyRegister();
        policyRegister.setCompanyName("State Farm");

        // Address
        Address address01 = new Address("123 Main St", "", "Address City 01", "12345", "Address State 01");
        Address address02 = new Address("456 Elm St", "Apt 101", "Address City 02", "67890", "Address State 02");
        Address address03 = new Address("789 Oak St", "", "Address City 03", "54321", "Address State 03");
        Address address04 = new Address("111 Maple St", "", "Address City 04", "13579", "Address State 04");
        Address address05 = new Address("222 Birch St", "Unit 303", "Address City 05", "86420", "Address State 05");
        Address address06 = new Address("333 Elm St", "Apt 202", "Address City 06", "98765", "Address State 06");
        Address address07 = new Address("444 Oak St", "Suite 303", "Address City 07", "11111", "Address State 07");
        Address address08 = new Address("555 Cedar St", "Unit 101", "Address City 08", "22222", "Address State 08");
        Address address09 = new Address("666 Pine St", "Apt 303", "Address City 09", "33333", "Address State 09");
        Address address10 = new Address("777 Spruce St", "Suite 101", "Address City 10", "44444", "Address State 10");
        Address address11 = new Address("888 Birch St", "Apt 303", "Address City 11", "55555", "Address State 11");
        Address address12 = new Address("999 Elm St", "Suite 101", "Address City 12", "66666", "Address State 12");
        Address address13 = new Address("1010 Oak St", "Apt 303", "Address City 13", "77777", "Address State 13");
        Address address14 = new Address("1111 Cedar St", "Suite 101", "Address City 14", "88888", "Address State 14");
        Address address15 = new Address("1212 Pine St", "Apt 303", "Address City 15", "99999", "Address State 15");
        Address address16 = new Address("1313 Spruce St", "Suite 101", "Address City 16", "10101", "Address State 16");
        Address address17 = new Address("1414 Birch St", "Apt 303", "Address City 17", "20202", "Address State 17");
        Address address18 = new Address("1515 Elm St", "Suite 101", "Address City 18", "30303", "Address State 18");
        Address address19 = new Address("1616 Oak St", "Apt 303", "Address City 19", "40404", "Address State 19");
        Address address20 = new Address("1717 Cedar St", "Suite 101", "Address City 20", "50505", "Address State 20");
        Address address21 = new Address("1818 Pine St", "Apt 303", "Address City 21", "60606", "Address State 21");
        Address address22 = new Address("1919 Spruce St", "Suite 101", "Address City 22", "70707", "Address State 22");
        Address address23 = new Address("2020 Birch St", "Apt 303", "Address City 23", "80808", "Address State 23");
        Address address24 = new Address("2121 Elm St", "Suite 101", "Address City 24", "90909", "Address State 24");
        Address address25 = new Address("2222 Oak St", "Apt 303", "Address City 25", "101010", "Address State 25");
        Address address26 = new Address("2323 Cedar St", "Suite 101", "Address City 26", "111111", "Address State 26");
        Address address27 = new Address("2424 Pine St", "Apt 303", "Address City 27", "121212", "Address State 27");
        Address address28 = new Address("2525 Spruce St", "Suite 101", "Address City 28", "131313", "Address State 28");
        Address address29 = new Address("2626 Birch St", "Apt 303", "Address City 29", "141414", "Address State 29");
        Address address30 = new Address("2727 Elm St", "Suite 101", "Address City 30", "151515", "Address State 30");

        // Person
        Person person01 = new Person("John", "Doe", "1990-01-01", "123-45-6789", address01, address01, address01);
        Person person02 = new Person("Jane", "Smith", "1985-05-15", "987-65-4321", address02, address02, address02);
        Person person03 = new Person("Alice", "Johnson", "1980-09-20", "234-56-7890", address03, address03, address03);
        Person person04 = new Person("Bob", "Brown", "1975-03-10", "345-67-8901", address04, address04, address04);
        Person person05 = new Person("Eva", "Williams", "1988-07-02", "456-78-9012", address05, address05, address05);
        Person person06 = new Person("David", "Lee", "1992-11-30", "567-89-0123", address06, address06, address06);
        Person person07 = new Person("Sarah", "Garcia", "1983-04-15", "678-90-1234", address07, address07, address07);
        Person person08 = new Person("Michael", "Martinez", "1995-12-25", "789-01-2345", address08, address08, address08);
        Person person09 = new Person("Olivia", "Hernandez", "1977-06-08", "890-12-3456", address09, address09, address09);
        Person person10 = new Person("William", "Lopez", "1986-02-19", "901-23-4567", address10, address10, address10);
        Person person11 = new Person("Mia", "Rodriguez", "1998-10-14", "012-34-5678", address11, address11, address11);
        Person person12 = new Person("James", "Perez", "1974-08-05", "123-45-6789", address12, address12, address12);
        Person person13 = new Person("Emily", "Gonzalez", "1991-03-26", "234-56-7890", address13, address13, address13);
        Person person14 = new Person("Alexander", "Taylor", "1981-01-03", "345-67-8901", address14, address14, address14);
        Person person15 = new Person("Grace", "Anderson", "1987-09-09", "456-78-9012", address15, address15, address15);
        Person person16 = new Person("Daniel", "Clark", "1989-12-01", "567-89-0123", address16, address16, address16);
        Person person17 = new Person("Ava", "White", "1978-05-18", "678-90-1234", address17, address17, address17);
        Person person18 = new Person("Logan", "Thomas", "1993-07-11", "789-01-2345", address18, address18, address18);
        Person person19 = new Person("Lily", "Davis", "1997-04-06", "890-12-3456", address19, address19, address19);
        Person person20 = new Person("Samuel", "Martin", "1984-11-28", "901-23-4567", address20, address20, address20);
        Person person21 = new Person("Chloe", "Harris", "1982-08-13", "012-34-5678", address21, address21, address21);
        Person person22 = new Person("Jacob", "Moore", "1976-06-22", "123-45-6789", address22, address22, address22);
        Person person23 = new Person("Sophia", "Allen", "1996-02-09", "234-56-7890", address23, address23, address23);
        Person person24 = new Person("Aiden", "Young", "1980-03-17", "345-67-8901", address24, address24, address24);
        Person person25 = new Person("Zoe", "King", "1994-12-04", "456-78-9012", address25, address25, address25);
        Person person26 = new Person("Caleb", "Scott", "1979-10-06", "567-89-0123", address26, address26, address26);
        Person person27 = new Person("Madison", "Lewis", "1987-07-23", "678-90-1234", address27, address27, address27);
        Person person28 = new Person("Henry", "Walker", "1992-04-29", "789-01-2345", address28, address28, address28);
        Person person29 = new Person("Avery", "Hall", "1986-01-12", "890-12-3456", address29, address29, address29);
        Person person30 = new Person("Sofia", "Adams", "1985-09-28", "901-23-4567", address30, address30, address30);

        // Car
        Car car01 = new Car("ABC123456", "Toyota", "Camry", 2022);
        Car car02 = new Car("XYZ789012", "Honda", "Accord", 2021);
        Car car03 = new Car("LMN345678", "Ford", "Fusion", 2020);
        Car car04 = new Car("PQR901234", "Chevrolet", "Malibu", 2019);
        Car car05 = new Car("DEF234567", "Nissan", "Altima", 2018);
        Car car06 = new Car("GHI456789", "Kia", "Optima", 2017);
        Car car07 = new Car("JKL678901", "Hyundai", "Sonata", 2016);
        Car car08 = new Car("MNO789012", "Mazda", "Mazda6", 2015);
        Car car09 = new Car("UVW012345", "Subaru", "Legacy", 2014);
        Car car10 = new Car("STU901234", "Volkswagen", "Passat", 2013);
        Car car11 = new Car("WXY123456", "BMW", "3 Series", 2022);
        Car car12 = new Car("QWE345678", "Mercedes-Benz", "C-Class", 2021);
        Car car13 = new Car("IOP567890", "Audi", "A4", 2020);
        Car car14 = new Car("JKL987654", "Lexus", "ES", 2019);
        Car car15 = new Car("GHU543210", "Infiniti", "Q50", 2018);
        Car car16 = new Car("XYZ876543", "Cadillac", "ATS", 2017);
        Car car17 = new Car("RST432109", "Lincoln", "MKZ", 2016);
        Car car18 = new Car("CDE210987", "Chrysler", "200", 2015);
        Car car19 = new Car("BNM654321", "Acura", "TLX", 2014);
        Car car20 = new Car("POI098765", "Volvo", "S60", 2013);

        // InsurancePolicy
        policyRegister.addInsurancePolicy(person01, person02, 1000.0, "2023-01-01", "2023-12-31", Arrays.asList(car01, car02), 5000.0);
        policyRegister.addInsurancePolicy(person03, person04, 1200.0, "2023-02-01", "2023-12-31", Arrays.asList(car03), 5500.0);
        policyRegister.addInsurancePolicy(person05, person06, 1500.0, "2023-03-01", "2023-12-31", Arrays.asList(car04), 6000.0);
        policyRegister.addInsurancePolicy(person07, person08, 1100.0, "2023-04-01", "2023-12-31", Arrays.asList(car05, car06), 5200.0);
        policyRegister.addInsurancePolicy(person09, person10, 1300.0, "2023-05-01", "2023-12-31", Arrays.asList(car07, car08), 5400.0);
        policyRegister.addInsurancePolicy(person11, person12, 900.0, "2023-06-01", "2023-12-31", Arrays.asList(car09), 4800.0);
        policyRegister.addInsurancePolicy(person13, person14, 1100.0, "2023-07-01", "2023-12-31", Arrays.asList(car10), 5200.0);
        policyRegister.addInsurancePolicy(person15, person16, 1400.0, "2023-08-01", "2023-12-31", Arrays.asList(car11), 5800.0);
        policyRegister.addInsurancePolicy(person17, person18, 1250.0, "2023-09-01", "2023-12-31", Arrays.asList(car12), 5600.0);
        policyRegister.addInsurancePolicy(person19, person20, 1050.0, "2023-10-01", "2023-12-31", Arrays.asList(car13), 5100.0);
        policyRegister.addInsurancePolicy(person21, person22, 1050.0, "2023-10-01", "2023-12-31", Arrays.asList(car14), 5100.0);
        policyRegister.addInsurancePolicy(person23, person24, 1050.0, "2023-10-01", "2023-12-31", Arrays.asList(car15), 5100.0);
        policyRegister.addInsurancePolicy(person25, person26, 1050.0, "2023-10-01", "2023-12-31", Arrays.asList(car16), 5100.0);
        policyRegister.addInsurancePolicy(person27, person28, 1050.0, "2023-10-01", "2023-12-31", Arrays.asList(car17, car18), 5100.0);
        policyRegister.addInsurancePolicy(person29, person30, 1050.0, "2023-10-01", "2023-12-31", Arrays.asList(car19, car20), 5100.0);

        // Print
        policyRegister.InsurancePolicyList();
    }
}