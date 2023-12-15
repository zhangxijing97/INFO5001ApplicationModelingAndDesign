/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.OrderManagement;

import java.util.ArrayList;

import model.CustomerManagement.CustomerProfile;
import model.SalesManagement.SalesPersonProfile;

/**
 *
 * @author kal bugrara
 */
public class MasterOrderList {
    ArrayList<Order> orders;
    MasterOrderReport masterOrderReport;

    public MasterOrderList() {
        orders = new ArrayList<Order>();

    }

    public Order newOrder(CustomerProfile cp) {
        Order o = new Order(cp);
        orders.add(o);
        return o;

    }

    public Order newOrder(CustomerProfile cp, SalesPersonProfile spp) {
        Order o = new Order(cp, spp);
        orders.add(o);

        return o;
    }

    public MasterOrderReport generateMasterOrderReport() {
        masterOrderReport = new MasterOrderReport();
        masterOrderReport.generateOrderReport(orders);

        return masterOrderReport;
    }

    public int getSalesVolume() {

        int sum = 0;
        for (Order order : orders) {
            sum = sum + order.getOrderTotal();
        }
        return sum;
    }

    public void printShortInfo() {
        System.out.println("Checking what's inside the master order list.");
        System.out.println("There are " + orders.size() + " order.");
    }

}
