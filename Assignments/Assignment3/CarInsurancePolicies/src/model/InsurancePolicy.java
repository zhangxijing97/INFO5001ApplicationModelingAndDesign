package model;

import java.util.List;

public class InsurancePolicy {

    private Person policyHolder;
    private Person secondDriver;
    private double amountOfPremium;
    private String startDate;
    private String endDate;
    private List<Car> cars;
    private double maximumCoverageLimit;

    public InsurancePolicy(Person policyHolder, Person secondDriver, double amountOfPremium, String startDate,
            String endDate, List<Car> cars, double maximumCoverageLimit) {
        this.policyHolder = policyHolder;
        this.secondDriver = secondDriver;
        this.amountOfPremium = amountOfPremium;
        this.startDate = startDate;
        this.endDate = endDate;
        this.cars = cars;
        this.maximumCoverageLimit = maximumCoverageLimit;
    }
    
    public void setPolicyHolder(Person policyHolder) {
        this.policyHolder = policyHolder;
    }
    public void setSecondDriver(Person secondDriver) {
        this.secondDriver = secondDriver;
    }
    public void setAmountOfPremium(double amountOfPremium) {
        this.amountOfPremium = amountOfPremium;
    }
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
    public void setCars(List<Car> cars) {
        this.cars = cars;
    }
    public void setMaximumCoverageLimit(double maximumCoverageLimit) {
        this.maximumCoverageLimit = maximumCoverageLimit;
    }

    public Person getPolicyHolder() {
        return policyHolder;
    }
    public Person getSecondDriver() {
        return secondDriver;
    }
    public double getAmountOfPremium() {
        return amountOfPremium;
    }
    public String getStartDate() {
        return startDate;
    }
    public String getEndDate() {
        return endDate;
    }
    public List<Car> getCars() {
        return cars;
    }
    public double getMaximumCoverageLimit() {
        return maximumCoverageLimit;
    }

    public void printInfo() {
        System.out.println("");
    }

    public void printinfo() {
        System.out.println("");
        System.out.println("Policy Holder: ");
        policyHolder.printInfo();
        System.out.println("");
        System.out.println("Second Driver: ");
        secondDriver.printInfo();

        System.out.println("");
        System.out.println("Premium Amount: " + amountOfPremium);
        System.out.println("Start Date: " + startDate);
        System.out.println("End Date: " + endDate);

        System.out.println("");
        System.out.println("Cars:");
        for (Car car : cars) {
            car.printInfo();
            // System.out.println("  " + car);
        }

        System.out.println("");
        System.out.println("Maximum Coverage Limit: " + maximumCoverageLimit);
    }
}
