/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Supplier;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import model.CustomerManagement.CustomerProfile;
import model.OrderManagement.Order;

/**
 *
 * @author kal bugrara
 */
public class SupplierDirectory {
    ArrayList<Supplier> suppliers;
    public SupplierDirectory(){
        suppliers = new ArrayList();
    }

    public Supplier newSupplier(String n){
        Supplier supplier = new Supplier(n);
        suppliers.add(supplier);
        return supplier;
    }

    public Supplier findSupplier(String id){
        
        for (Supplier supplier: suppliers){
            
            if(supplier.getName().equals(id)) return supplier;
        }
        return null;
        }
    public ArrayList<Supplier> getSuplierList(){
        return suppliers;
    }

    public Supplier pickRandomSupplier(){
        if (suppliers.size() == 0) return null;
        Random r = new Random();
        int randomIndex = r.nextInt(suppliers.size());
        return suppliers.get(randomIndex);
    }

    public Supplier pickRandomSupplierFromFirstTen() {
        if (suppliers.size() < 10) {
            // Handle the case where there are less than 10 suppliers
            return null;
        }
    
        Random r = new Random();
        int randomIndex = r.nextInt(10); // Picks a random index between 0 and 9 (inclusive)
        return suppliers.get(randomIndex);
    }

    public List<Supplier> getSuppliers() {
        return suppliers;
    }
    
    public void printShortInfo(){
        System.out.println("Checking what's inside the supplier directory.");
        System.out.println("There are " + suppliers.size() + " suppliers.");
        for (Supplier s: suppliers){
            s.printShortInfo();
        }
    }

}