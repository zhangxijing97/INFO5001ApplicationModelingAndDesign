package model;
import java.util.ArrayList;
import java.util.List;

public class InsurancePolicyRegister {

    // companyName
    private String companyName;
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
    public String getCompanyName() {
        return companyName;
    }

    // listOfInsurancePolicies
    // private List<InsurancePolicy> listOfInsurancePolicies;
    ArrayList<InsurancePolicy> listOfInsurancePolicies;

    public InsurancePolicyRegister() {
        listOfInsurancePolicies = new ArrayList<InsurancePolicy>();
    }

    public InsurancePolicy addInsurancePolicy(Person policyHolder, Person secondDriver, double amountOfPremium, String startDate,
    String endDate, List<Car> cars, double maximumCoverageLimit) {
        InsurancePolicy policy = new InsurancePolicy(policyHolder, secondDriver, amountOfPremium, startDate,
        endDate, cars, maximumCoverageLimit);
        listOfInsurancePolicies.add(policy);
        return policy;
    }

    public void InsurancePolicyList() {
        System.out.println("Insurance Policy List: ");
        int policyCount = 0;

        for (InsurancePolicy insurancePolicy: listOfInsurancePolicies) {
            policyCount++;
            System.out.println("**************************************************");
            System.out.println("Policy " + policyCount);
            insurancePolicy.printinfo();
            System.out.println("");
        }
    }
}
