/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

import com.github.javafaker.Faker;

import model.Business.Business;
import model.Business.ConfigureABusiness;
import model.CustomerManagement.CustomerDirectory;
import model.CustomerManagement.CustomerProfile;
import model.OrderManagement.MasterOrderList;
import model.OrderManagement.MasterOrderReport;
import model.ProductManagement.ProductCatalog;
import model.ProductManagement.ProductsReport;
import model.Supplier.Supplier;
import model.Supplier.SupplierDirectory;
import model.Supplier.SuppliersReport;

/**
 *
 * @author kal bugrara
 */
public class DigitalMarketingApplication {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {

    // Part 1 – Populating the model – (40 pts)
    // a. Business - 1.
    // b. Suppliers - 50.
    // c. Pick any 30 Suppliers and add 50 Products to each.
    // d. Customers - 300.
    // e. Every Customer should have 1-3 Orders with 1-10 Items to each.
    Business business = ConfigureABusiness.createABusinessAndLoadALotOfData("Amazon", 50, 50, 300, 3, 10);
    business.printShortInfo(); // Check populating success or not

    // Part 2 – Reports (60 pts)
    // Create a SupplierReport and SupplierSummary classes and add the following:
    // - Supplier Name,
    // - Total Sales,
    // - Loyalty score (Number of different customers who picked suppliers products
    // divided by number of all customers)
    // - Average spending per customer (Total sales divided by number of different
    // customers)
    // - Top 5 Sales Score (Total sales to top 5 Customers divided by total sales)

    SupplierDirectory supplierDirectory = business.getSupplierDirectory();
    SuppliersReport mySuppliersReport = supplierDirectory.generateSuppliersReport();
    mySuppliersReport.printSuppliersReport();

    // for (Supplier supplier : supplierDirectory.getSuplierList()) {
    // supplier.supplierReport(business.getCustomerDirectory());
    // }

  }
}