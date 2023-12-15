/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.CustomerManagement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import model.MarketModel.Market;
import model.ProductManagement.Product;
import model.ProductManagement.SolutionOffer;

/**
 *
 * @author kal bugrara
 */
public class MarketCatalog {

    ArrayList<Market> markets;

    public MarketCatalog() {
        markets = new ArrayList<Market>();
    }

    public Market newMarket(String s) {
        Market m = new Market(s);
        markets.add(m);
        return m;
    }

    public void generateMarketReport() {
        System.out.println("Market Report:");

        for (Market market : markets) {
            System.out.println("Market Characteristic: " + market.getCharacteristic());

            if (market.getSolutionOffer() != null) {
                SolutionOffer solutionOffer = market.getSolutionOffer();
                // System.out.println("Solution Offer Price: " + solutionOffer.getPrice());
                System.out.println("Total Sales for Solution Offer(solution bundles): " + solutionOffer.getPrice());

                int totalrevenues = solutionOffer.getPrice();

                if (solutionOffer.getMarketChannelAssignment().getChannel().getChannelType() == "web") {
                    totalrevenues = totalrevenues - 1;
                } else if (solutionOffer.getMarketChannelAssignment().getChannel().getChannelType() == "social media") {
                    totalrevenues = totalrevenues - 2;
                } else if (solutionOffer.getMarketChannelAssignment().getChannel().getChannelType() == "tv") {
                    totalrevenues = totalrevenues - 3;
                } else if (solutionOffer.getMarketChannelAssignment().getChannel().getChannelType() == "radio") {
                    totalrevenues = totalrevenues - 4;
                } else {
                    totalrevenues = totalrevenues - 0;
                }

                System.out.println("Total Revenues(minus ad spend): " + totalrevenues);

                ArrayList<Product> products = solutionOffer.getProducts();
                System.out.println("Products in Solution Offer:");
                for (Product product : products) {
                    System.out.println("  - " + product.getName() + ", Price: " + product.getTargetPrice());
                }
            } else {
                System.out.println("No Solution Offer for this market.");
            }

            System.out.println(); // Add a newline for better readability
        }
    }

    public void generateMarketReportByCharacteristic() {
        System.out.println("Market Report by Markets:");

        String[] knownCharacteristics = { "students", "educators", "workers", "professionals", "entrepreneurs",
                "others" };

        for (String characteristic : knownCharacteristics) {
            int characteristicTotalPrice = 0;
            int totalrevenues = 0;

            for (Market market : markets) {
                if (characteristic.equals(market.getCharacteristic()) && market.getSolutionOffer() != null) {
                    characteristicTotalPrice += market.getSolutionOffer().getPrice();
                    totalrevenues += market.getSolutionOffer().getPrice();

                    if (market.getMarketChannelAssignment().getChannel().getChannelType() == "web") {
                        totalrevenues = totalrevenues - 1;
                    } else if (market.getMarketChannelAssignment().getChannel().getChannelType() == "social media") {
                        totalrevenues = totalrevenues - 2;
                    } else if (market.getMarketChannelAssignment().getChannel().getChannelType() == "tv") {
                        totalrevenues = totalrevenues - 3;
                    } else if (market.getMarketChannelAssignment().getChannel().getChannelType() == "radio") {
                        totalrevenues = totalrevenues - 4;
                    } else {
                        totalrevenues = totalrevenues - 0;
                    }
                }
            }
            System.out.println("--------------------------------------------------");
            System.out.println("Market: " + characteristic);
            System.out.println("Total Sale: " + characteristicTotalPrice);
            System.out.println("Total Revenues(minus ad spend): " + totalrevenues);
            System.out.println("--------------------------------------------------");
        }
    }

}
