/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.MarketModel;

import java.util.ArrayList;

import model.ProductManagement.SolutionOffer;

/**
 *
 * @author kal bugrara
 */
public class Market {

    String characteristic;
    MarketChannelAssignment marketChannelAssignment;

    SolutionOffer solutionOffer;

    public Market(String s) {
        characteristic = s;
    }

    public String getCharacteristic() {
        return characteristic;
    }

    public void setMarketChannelAssignment(MarketChannelAssignment marketChannelAssignment) {
        this.marketChannelAssignment = marketChannelAssignment;
    }

    public void setSolutionOffer(SolutionOffer solutionOffer) {
        this.solutionOffer = solutionOffer;
    }

    public SolutionOffer getSolutionOffer() {
        return solutionOffer;
    }

    public MarketChannelAssignment getMarketChannelAssignment() {
        return marketChannelAssignment;
    }

}
