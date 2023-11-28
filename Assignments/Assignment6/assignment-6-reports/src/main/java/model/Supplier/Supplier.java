/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Supplier;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.github.javafaker.Business;

import model.CustomerManagement.CustomerDirectory;
import model.CustomerManagement.CustomerProfile;
import model.OrderManagement.Order;
import model.OrderManagement.OrderItem;
import model.ProductManagement.Product;
import model.ProductManagement.ProductCatalog;
import model.ProductManagement.ProductSummary;
import model.ProductManagement.ProductsReport;

/**
 *
 * @author kal bugrara
 */
public class Supplier {
    String name;
    ProductCatalog productcatalog;
    ProductsReport productsreport;

    public Supplier(String n) {
        name = n;
        productcatalog = new ProductCatalog("software");

    }

    public ProductsReport prepareProductsReport() {

        productsreport = productcatalog.generateProductPerformanceReport("");
        return productsreport;
    }

    public ArrayList<ProductSummary> getProductsAlwaysAboveTarget() {

        if (productsreport == null)
            productsreport = prepareProductsReport();
        return productsreport.getProductsAlwaysAboveTarget();

    }

    public String getName() {
        return name;
    }

    public ProductCatalog getProductCatalog() {
        return productcatalog;
    }

    public void printShortInfo() {
        System.out.println("Checking supplier " + name);
        productcatalog.printShortInfo();
    }

    public void supplierReport(CustomerDirectory cd) {
        System.out.println("----------------------------------------");
        System.out.println("Report of Supplier " + name);
        System.out.println("Name: " + name);
        // productcatalog.printShortInfo();
        int totalSales = getTotalSales();
        System.out.println("Total Sales: " + totalSales);

        int numberOfCustomers = getNumberOfCustomers();
        int totalNumberOfCustomers = getNumberOfAllCustomers(cd);
        double loyaltyScoreRatio = (double) numberOfCustomers / totalNumberOfCustomers;

        System.out.println(
                "Loyalty score: " + loyaltyScoreRatio + "(" + getNumberOfCustomers() + "/"
                        + getNumberOfAllCustomers(cd) + ")");

        double averageSpending = (double) totalSales / numberOfCustomers;
        System.out.println("Average spending per customer: " + averageSpending);

        double topSalesScore = (double) getSumOfLargestFive() / totalSales;

        System.out.println("Top 5 Sales Score: " + topSalesScore + "(" + getSumOfLargestFive() + "/"
                + totalSales + ")");
        // System.out.println(getSumOfLargestFive());
        // System.out.println(getTotalSpendingCustomers());
        System.out.println("");
    }

    public int getTotalSales() {
        int totalSales = 0;
        // for (Product product : productcatalog.getProductList()) {
        // for (OrderItem orderItem : product.getOrderItems()) {
        // totalSales += orderItem.getActualPrice() * orderItem.getQuantity();
        // }
        // }
        for (int totalSpendingCustomer : getTotalSpendingCustomers()) {
            totalSales += totalSpendingCustomer;
        }
        return totalSales;
    }

    public int getNumberOfCustomers() {
        Set<String> uniqueCustomers = new HashSet<>();

        for (Product product : productcatalog.getProductList()) {
            for (OrderItem orderItem : product.getOrderItems()) {
                String id = orderItem.getCustomer().getCustomerId();
                uniqueCustomers.add(id);
            }
        }
        return uniqueCustomers.size();
    }

    public int getNumberOfAllCustomers(CustomerDirectory customerDirectory) {
        return customerDirectory.getCustomers().size();
    }

    public Set<CustomerProfile> getCustomers() {
        Set<CustomerProfile> uniqueCustomers = new HashSet<>();

        for (Product product : productcatalog.getProductList()) {
            for (OrderItem orderItem : product.getOrderItems()) {
                CustomerProfile customerProfile = orderItem.getCustomer();
                uniqueCustomers.add(customerProfile);
            }
        }
        return uniqueCustomers;
    }

    public List<Integer> getTotalSpendingCustomers() {
        List<CustomerProfile> customers = new ArrayList<>(getCustomers());
        List<Integer> totalSpendings = new ArrayList<>();

        for (CustomerProfile customer : customers) {
            int totalSpending = customer.getTotalSpending();
            totalSpendings.add(totalSpending);
        }
        return totalSpendings;
    }

    public int getSumOfLargestFive() {
        List<CustomerProfile> customers = new ArrayList<>(getCustomers());
        List<Integer> totalSpendings = new ArrayList<>();

        for (CustomerProfile customer : customers) {
            int totalSpending = customer.getTotalSpending();
            totalSpendings.add(totalSpending);
        }

        // Sort the list in descending order
        Collections.sort(totalSpendings, Collections.reverseOrder());

        // Sum the largest five elements
        int sumOfLargestFive = 0;
        for (int i = 0; i < Math.min(5, totalSpendings.size()); i++) {
            sumOfLargestFive += totalSpendings.get(i);
        }

        return sumOfLargestFive;
    }

    // add supplier product ..

    // update supplier product ...
    @Override
    public String toString() {
        return name;

    }
}
