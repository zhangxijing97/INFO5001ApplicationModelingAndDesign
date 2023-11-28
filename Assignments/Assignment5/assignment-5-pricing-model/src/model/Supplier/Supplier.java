/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Supplier;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    public Supplier(String n){
        name = n;
        productcatalog = new ProductCatalog("software");
        
    }
    
    public ProductsReport prepareProductsReport(){
        
        productsreport = productcatalog.generatProductPerformanceReport();
        return productsreport;
    }
    
    public ArrayList<ProductSummary> getProductsAlwaysAboveTarget(){
       
        if(productsreport==null) productsreport = prepareProductsReport();
       return productsreport.getProductsAlwaysAboveTarget();
       
    }
    
    public String getName(){
        return name;
    }
        
    
    public ProductCatalog getProductCatalog(){
        return productcatalog;
    }
    
    public void printShortInfo(){
        System.out.println("Checking supplier " + name);
        productcatalog.printShortInfo();
    }

    //add supplier product ..
    
    //update supplier product ...
    @Override
    
    public String toString(){
        return name;
        
    }

    public Product findMostExpensiveProduct() {
        ArrayList<Product> products = productcatalog.getProductList();
        Product mostExpensiveProduct = null;
        int maxPrice = Integer.MIN_VALUE; // Assuming prices are integers

        for (Product product : products) {
            int productPrice = product.getTargetPrice(); // or use other price attribute as needed

            if (productPrice > maxPrice) {
                maxPrice = productPrice;
                mostExpensiveProduct = product;
            }
        }

        return mostExpensiveProduct;
    }
    // public int getTotalSales() {
    //     int totalSales = 0;

    //     for (Product product : productcatalog.getProductList()) {
    //         for (OrderItem orderItem : product.getOrderItems()) {
    //             totalSales += orderItem.getActualPrice();
    //         }
    //     }
    //     return totalSales;
    // }

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

    public int getTotalSales() {
        int totalSales = 0;
        for (int totalSpendingCustomer : getTotalSpendingCustomers()) {
            totalSales += totalSpendingCustomer;
        }
        return totalSales;
    }

}
