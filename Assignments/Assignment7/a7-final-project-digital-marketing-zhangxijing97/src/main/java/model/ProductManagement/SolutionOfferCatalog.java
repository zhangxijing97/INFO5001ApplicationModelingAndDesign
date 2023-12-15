/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.ProductManagement;

import java.util.ArrayList;

import model.MarketModel.Channel;
import model.MarketModel.MarketChannelAssignment;

/**
 *
 * @author kal bugrara
 */
public class SolutionOfferCatalog {
    ArrayList<SolutionOffer> solutionoffers;

    public SolutionOfferCatalog() {
        // solutionoffers = new ArrayList<>();
        solutionoffers = new ArrayList<SolutionOffer>();
    }

    public SolutionOffer newSolutionOffer(MarketChannelAssignment mca) {
        SolutionOffer so = new SolutionOffer(mca);
        solutionoffers.add(so);
        return so;
    }

    public void generateChannelTypeReport(String channelType) {
        System.out.println("--------------------------------------------------");
        System.out.println("Channel Type: " + channelType);
        int totalChannelTypePrice = 0;
        int totalrevenues = 0;

        for (SolutionOffer solutionOffer : solutionoffers) {
            MarketChannelAssignment mca = solutionOffer.getMarketChannelAssignment();
            Channel channel = mca.getChannel();

            if (channel != null && channelType.equals(channel.getChannelType())) {
                int solutionOfferPrice = solutionOffer.getPrice();
                // System.out.println("Solution Offer Price: " + solutionOfferPrice);
                totalChannelTypePrice += solutionOfferPrice;
                totalrevenues += solutionOfferPrice;

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
            }
        }

        System.out.println("Total Sales for Channel Type '" + channelType + "': " + totalChannelTypePrice);
        System.out.println("Total Revenues(minus ad spend): " + totalrevenues);
        System.out.println("--------------------------------------------------");
    }

    public void generateChannelReport(String channelName) {
        System.out.println("--------------------------------------------------");
        System.out.println("Channel: " + channelName);
        int totalChannelTypePrice = 0;
        int totalrevenues = 0;

        for (SolutionOffer solutionOffer : solutionoffers) {
            MarketChannelAssignment mca = solutionOffer.getMarketChannelAssignment();
            Channel channel = mca.getChannel();

            if (channel != null && channelName.equals(channel.getName())) {
                int solutionOfferPrice = solutionOffer.getPrice();
                // System.out.println("Solution Offer Price: " + solutionOfferPrice);
                totalChannelTypePrice += solutionOfferPrice;
                totalrevenues += solutionOfferPrice;

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
            }
        }

        System.out.println("Total Sales for Channel Type '" + channelName + "': " + totalChannelTypePrice);
        System.out.println("Total Revenues(minus ad spend): " + totalrevenues);
        System.out.println("--------------------------------------------------");
    }

}
