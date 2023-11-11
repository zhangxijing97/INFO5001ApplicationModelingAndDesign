/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.util.List;

import model.Business.Business;
import model.Business.ConfigureABusiness;
import model.CustomerManagement.CustomerDirectory;
import model.CustomerManagement.CustomerProfile;
import model.ProductManagement.Product;
import model.ProductManagement.ProductCatalog;
import model.ProductManagement.ProductsReport;
import model.Supplier.Supplier;
import model.Supplier.SupplierDirectory;

/**
 *
 * @author kal bugrara
 */
public class RangePricingApplication {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    // TODO code application logic here

    // Part 1 – Populating the model – (40 pts)
    // a. Business - 1.
    // b. Suppliers - 30.
    // c. Pick any 10 Suppliers and add 20 Products to each.
    // d. Customers - 50.
    // e. Pick any 25 Customers and add 1-3 Orders with 1-10 Items to each.
    Business business = ConfigureABusiness.createABusinessAndLoadALotOfData("Amazon", 30, 0, 50, 3, 10);
    business.printShortInfo();

    // Part 2 – Let’s answer questions (60 pts)
    // - Pick three random Customers and print out their Sales orders
    System.out.println("**************************************************");
    System.out.println("Pick three random Customers and print out their Sales orders:");
    CustomerDirectory customerDirectory = business.getCustomerDirectory();
    // Pick first random Customer
    CustomerProfile customer01 = customerDirectory.pickRandomCustomer();
    System.out.println("Sales orders for Customer: " + customer01.getCustomerId());
    customer01.printOrderShortInfo(); // Assuming this method exists in CustomerProfile class
    System.out.println("----------------------------------------");
    // Pick second random Customer
    CustomerProfile customer02 = customerDirectory.pickRandomCustomer();
    System.out.println("Sales orders for Customer: " + customer02.getCustomerId());
    customer02.printOrderShortInfo(); // Assuming this method exists in CustomerProfile class
    System.out.println("----------------------------------------");
    // Pick third random Customer
    CustomerProfile customer03 = customerDirectory.pickRandomCustomer();
    System.out.println("Sales orders for Customer: " + customer03.getCustomerId());
    customer03.printOrderShortInfo(); // Assuming this method exists in CustomerProfile class
    System.out.println("----------------------------------------");

    // - Pick three random Suppliers and find their most expensive products.
    System.out.println("**************************************************");
    System.out.println("Pick three random Suppliers and find their most expensive products.:");
    SupplierDirectory supplierDirectory = business.getSupplierDirectory();
    // Pick first Supplier
    Supplier supplier01 = supplierDirectory.pickRandomSupplier();
    System.out.println("Supplier: " + supplier01 .getName());
    supplier01.printShortInfo();

    Product mostExpensiveProduct01 = supplier01.findMostExpensiveProduct();
    if (mostExpensiveProduct01 != null) {
    System.out.println("The most expensive product price is: " + mostExpensiveProduct01.getTargetPrice());
    } else {
        System.out.println("No products found for this supplier.");
    }
    System.out.println("----------------------------------------");
    // Pick second Supplier
    Supplier supplier02 = supplierDirectory.pickRandomSupplier();
    System.out.println("Supplier: " + supplier02.getName());
    supplier02.printShortInfo();

    Product mostExpensiveProduct02 = supplier02.findMostExpensiveProduct();
    if (mostExpensiveProduct02 != null) {
    System.out.println("The most expensive product price is: " + mostExpensiveProduct02.getTargetPrice());
    } else {
        System.out.println("No products found for this supplier.");
    }
    System.out.println("----------------------------------------");

    // Pick third Supplier
    Supplier supplier03 = supplierDirectory.pickRandomSupplier();
    System.out.println("Supplier: " + supplier03.getName());
    supplier03.printShortInfo();

    Product mostExpensiveProduct03 = supplier03.findMostExpensiveProduct();
    if (mostExpensiveProduct03 != null) {
    System.out.println("The most expensive product price is: " + mostExpensiveProduct03.getTargetPrice());
    } else {
        System.out.println("No products found for this supplier.");
    }
    System.out.println("----------------------------------------");

    // - Find a customer who spend most money with us.
    CustomerProfile customerWithMostSpending = null;
    int maxSpending = 0;

    for (CustomerProfile customer : customerDirectory.getCustomers()) {
        int totalSpending = customer.getTotalSpending();

        if (totalSpending > maxSpending) {
            maxSpending = totalSpending;
            customerWithMostSpending = customer;
        }
    }

    if (customerWithMostSpending != null) {
        // Customer with the most spending
        System.out.println("Customer with the most spending: " + customerWithMostSpending.getCustomerId());
        System.out.println("Amount: " + customerWithMostSpending.getTotalSpending());
    } else {
        // No customers found or no spending recorded
        System.out.println("No customers or spending recorded.");
    }

    // - Find a Supplier with most sales.
    Supplier supplierWithMostSales = null;
    int maxSales = 0;

    for (Supplier supplier : supplierDirectory.getSuppliers()) {
        int totalSales = supplier.getTotalSales(); // Assuming this method calculates total sales for each supplier

        if (totalSales > maxSales) {
            maxSales = totalSales;
            supplierWithMostSales = supplier;
        }
    }

    if (supplierWithMostSales != null) {
        // Supplier with the most sales
        System.out.println("Supplier with the most sales: " + supplierWithMostSales.getName());
        System.out.println("Amount: " + supplierWithMostSales.getTotalSales());
    } else {
        // No suppliers found or no sales recorded
        System.out.println("No suppliers or sales recorded.");
    }

    // - Find a Supplier with least sales (do not include Supplier with zero sales).
    Supplier supplierWithLeastSales = null;
    int minSales = 9999;

    for (Supplier supplier : supplierDirectory.getSuppliers()) {
        int totalSales = supplier.getTotalSales(); // Assuming this method calculates total sales for each supplier

        if (totalSales < minSales && totalSales != 0 ) {
            minSales = totalSales;
            supplierWithLeastSales = supplier;
        }
    }

    if (supplierWithLeastSales != null) {
        // Supplier with the most sales
        System.out.println("Supplier with the least sales: " + supplierWithLeastSales.getName());
        System.out.println("Amount: " + supplierWithLeastSales.getTotalSales());
    } else {
        // No suppliers found or no sales recorded
        System.out.println("No suppliers or sales recorded.");
    }
  }
}
