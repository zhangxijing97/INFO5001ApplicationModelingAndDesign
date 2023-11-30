package model.Supplier;

import java.util.ArrayList;
import java.util.Collections;

import model.CustomerManagement.CustomerDirectory;
import model.ProductManagement.ProductSummary;
import model.ProductManagement.ProductSummaryComparator;

public class SuppliersReport {

    ArrayList<SupplierSummary> suppliersummarylist;

    public SuppliersReport() {
        suppliersummarylist = new ArrayList<SupplierSummary>();
        /// We could make it "prepopulate" with the existing product data
    }

    public void addSupplierSummary(SupplierSummary ss) {

        suppliersummarylist.add(ss);

        // ProductSummaryComparator comparator = new
        // ProductSummaryComparator(sortingRule);
        // Collections.sort(productsummarylist, comparator);

    }

    public void printSuppliersReport() {
        System.out.println("Supplier Report");
        for (SupplierSummary ss : suppliersummarylist) {
            // int index = suppliersummarylist.indexOf(ss);
            // System.out.print((index + 1) + " ");
            ss.printSupplierSummary();

        }
    }

}