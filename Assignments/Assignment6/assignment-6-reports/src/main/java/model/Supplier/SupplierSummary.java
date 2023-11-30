package model.Supplier;

import com.github.javafaker.Business;

import model.CustomerManagement.CustomerDirectory;
import model.ProductManagement.Product;

public class SupplierSummary {
    Supplier supplier;

    String name;
    int totalSales;
    int numberOfCustomers;
    double sumOfLargestFive;

    public SupplierSummary(Supplier s) {
        name = s.getName();
        totalSales = s.getTotalSales();
        numberOfCustomers = s.getNumberOfCustomers();
        sumOfLargestFive = s.getSumOfLargestFive();
    }

    public void printSupplierSummary() {
        System.out.println("----------------------------------------");
        System.out.println("Report of Supplier " + name);
        System.out.println("Name: " + name);
        System.out.println("Total Sales: " + totalSales);

        int totalNumberOfCustomers = 300;
        double loyaltyScoreRatio = (double) numberOfCustomers /
                totalNumberOfCustomers;

        System.out.println(
                "Loyalty score: " + loyaltyScoreRatio + "(" + numberOfCustomers
                        + "/"
                        + 300 + ")");

        double averageSpending = (double) totalSales / numberOfCustomers;
        System.out.println("Average spending per customer: " + averageSpending);

        double topSalesScore = (double) sumOfLargestFive / totalSales;

        System.out.println("Top 5 Sales Score: " + topSalesScore + "(" +
                sumOfLargestFive + "/"
                + totalSales + ")");
        System.out.println("");
    }

}
